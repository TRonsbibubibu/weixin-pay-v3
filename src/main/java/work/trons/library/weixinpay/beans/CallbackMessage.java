package work.trons.library.weixinpay.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CallbackMessage {
    @JsonProperty("id")
    private String id;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("resource_type")
    private String resourceType;
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("resource")
    private Resource resource;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resource {
        @JsonProperty("algorithm")
        private String algorithm;
        @JsonProperty("ciphertext")
        private String ciphertext;
        private String decrypttext;
        @JsonProperty("original_type")
        private String originalType;
        @JsonProperty("nonce")
        private String nonce;
        @JsonProperty("associated_data")
        private String associatedData;
    }
}
