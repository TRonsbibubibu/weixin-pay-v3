package work.trons.library.weixin.beans.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixin.beans.BaseResponse;

import java.util.Date;
import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/8
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformCertResponse extends BaseResponse {
    private List<PlatformCert> data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlatformCert{
        @JsonProperty("serial_no")
        private String serialNo;
        @JsonProperty("encrypt_certificate")
        private EncryptCertificate encryptCertificate;
        @JsonProperty("effective_time")
        private String effectiveTime;
        @JsonProperty("expire_time")
        private Date expireTime;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EncryptCertificate{
        private String algorithm;
        @JsonProperty("associated_data")
        private String associatedData;
        private String ciphertext;
        private String nonce;
    }
}
