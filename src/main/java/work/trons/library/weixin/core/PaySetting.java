package work.trons.library.weixin.core;

import lombok.Getter;
import lombok.SneakyThrows;
import work.trons.library.weixin.api.CommonApi;
import work.trons.library.weixin.beans.common.PlatformCertResponse;
import work.trons.library.weixin.utils.EncryptUtils;
import work.trons.library.weixin.utils.CollectionUtils;
import work.trons.library.weixin.utils.RSAUtils;
import work.trons.library.weixin.utils.StringUtils;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Comparator;
import java.util.List;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Getter
public class PaySetting {
    private String signatureAlgorithm;
    private PrivateKey mchPrivateKey;
    private PublicKey mchPublicKey;
    private String mchId;
    private String mchSerialNo;
    private byte[] aesKey;
    private String platformSerialNo;
    private PublicKey platformPublicKey;

    private PaySetting() {
    }

    private PaySetting(Builder builder) {
        this.mchPublicKey = builder.publicKey;
        this.mchPrivateKey = builder.privateKey;
        this.mchId = builder.mchId;
        this.mchSerialNo = builder.serialNo;
        this.signatureAlgorithm = "SHA256withRSA";
        this.aesKey = builder.aesKey.getBytes();
        this.platformSerialNo = StringUtils.EMPTY;
        this.platformPublicKey = null;
        loadPlatformCert();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @SneakyThrows
    private void loadPlatformCert() {
        PlatformCertResponse platformCertResponse = CommonApi.with(this).platformCert();
        List<PlatformCertResponse.PlatformCert> certs = platformCertResponse.getData();
        certs.sort(Comparator.comparing(PlatformCertResponse.PlatformCert::getExpireTime));
        PlatformCertResponse.PlatformCert platformCert = certs.get(0);
        PlatformCertResponse.EncryptCertificate certData = platformCert.getEncryptCertificate();
        String certStr = EncryptUtils.aesDecryptToString(this.aesKey, certData.getAssociatedData().getBytes(), certData.getNonce().getBytes(), certData.getCiphertext());
        Certificate cert = RSAUtils.loadCertificate(certStr);
        this.platformSerialNo = platformCert.getSerialNo();
        this.platformPublicKey = cert.getPublicKey();
    }

    public static class Builder {
        private PublicKey publicKey;
        private PrivateKey privateKey;
        private String serialNo;
        private InputStream certStream;
        private String mchId;
        private String aesKey;

        @SneakyThrows
        public Builder certificate(InputStream in) {
            this.certStream = in;
            return this;
        }

        public Builder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public Builder aesKey(String aesKey) {
            this.aesKey = aesKey;
            return this;
        }

        @SneakyThrows
        public PaySetting build() {

            if (StringUtils.isBlank(mchId)) {
                throw new IllegalArgumentException("商户号不能为空");
            }

            if (certStream == null) {
                throw new IllegalArgumentException("证书不能为空");
            }

            if (StringUtils.isBlank(aesKey)) {
                throw new IllegalArgumentException("APIv3密钥不能为空");
            }

            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(certStream, mchId.toCharArray());
            List<String> aliases = CollectionUtils.toList(keyStore.aliases());
            if (CollectionUtils.isEmpty(aliases)) {
                throw new IllegalArgumentException("证书alias为空");
            }

            String alias = aliases.get(0);
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
            this.serialNo = cert.getSerialNumber().toString(16).toUpperCase();
            this.publicKey = cert.getPublicKey();
            this.privateKey = (PrivateKey) keyStore.getKey(alias, mchId.toCharArray());
            return new PaySetting(this);
        }
    }
}
