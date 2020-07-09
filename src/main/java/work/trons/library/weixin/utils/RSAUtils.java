package work.trons.library.weixin.utils;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
public class RSAUtils {

    @SneakyThrows
    public static Certificate loadCertificate(String certStr) {
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(certStr.getBytes()));
        return cert;
    }

    @SneakyThrows
    public static String sign(PrivateKey privateKey, String content, String signAlgorithm) {
        Signature signer = Signature.getInstance(signAlgorithm);
        signer.initSign(privateKey);
        signer.update(content.getBytes());
        return Base64.getEncoder().encodeToString(signer.sign());
    }

    @SneakyThrows
    public static boolean verify(String sign, PublicKey publicKey, String content, String signAlgorithm) {
        byte[] signBytes = Base64.getDecoder().decode(sign);
        Signature signer = Signature.getInstance(signAlgorithm);
        signer.initVerify(publicKey);
        signer.update(content.getBytes());
        return signer.verify(signBytes);
    }

    @SneakyThrows
    public static String encrypt(String message, PublicKey publicKey) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        byte[] cipherdata = cipher.doFinal(data);
        return Base64.getEncoder().encodeToString(cipherdata);
    }

    @SneakyThrows
    public static String decrypt(String ciphertext, PrivateKey privateKey) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] data = Base64.getDecoder().decode(ciphertext);
        return new String(cipher.doFinal(data), StandardCharsets.UTF_8);
    }
}
