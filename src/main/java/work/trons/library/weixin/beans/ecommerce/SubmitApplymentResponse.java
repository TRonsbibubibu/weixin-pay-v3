package work.trons.library.weixin.beans.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixin.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitApplymentResponse extends BaseResponse {
    @JsonProperty("applyment_id")
    private Long applymentId;
    @JsonProperty("out_request_no")
    private String outRequestNo;
}
