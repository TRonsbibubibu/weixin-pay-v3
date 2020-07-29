package work.trons.library.weixinpay.beans.complaint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/29
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryComplaintNotificationResponse extends BaseResponse {
    @JsonProperty("mchid")
    private String mchid;
    @JsonProperty("url")
    private String url;
}
