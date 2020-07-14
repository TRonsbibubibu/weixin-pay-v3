package work.trons.library.weixinpay.beans.ecommerce.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SubMchWithdrawResponse extends BaseResponse {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("withdraw_id")
    private String withdrawId;
    @JsonProperty("out_request_no")
    private String outRequestNo;
}
