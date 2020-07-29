package work.trons.library.weixinpay.beans.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectApplymentResponse extends BaseResponse {
    @JsonProperty("applyment_state")
    private String applymentState;
    @JsonProperty("qrcode_data")
    private String qrcodeData;
    @JsonProperty("reject_param")
    private String rejectParam;
    @JsonProperty("reject_reason")
    private String rejectReason;
}
