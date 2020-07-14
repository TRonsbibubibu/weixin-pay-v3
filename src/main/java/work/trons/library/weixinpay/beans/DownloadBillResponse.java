package work.trons.library.weixinpay.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/14
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadBillResponse extends BaseResponse {
    @JsonProperty("hash_type")
    private String hashType;
    @JsonProperty("hash_value")
    private String hashValue;
    @JsonProperty("download_url")
    private String downloadUrl;
}
