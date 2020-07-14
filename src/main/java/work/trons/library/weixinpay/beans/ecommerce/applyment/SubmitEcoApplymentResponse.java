package work.trons.library.weixinpay.beans.ecommerce.applyment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitEcoApplymentResponse extends BaseResponse {
    @JsonProperty("applyment_id")
    private String applymentId;
    @JsonProperty("out_request_no")
    private String outRequestNo;
}
