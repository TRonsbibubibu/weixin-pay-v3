package work.trons.library.weixinpay.beans.ecommerce.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/14
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MchWithdrawResponse extends BaseResponse {
    @JsonProperty("withdraw_id")
    private String withdrawId;
    @JsonProperty("out_request_no")
    private String outRequestNo;
}
