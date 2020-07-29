package work.trons.library.weixinpay.beans.ecommerce.profitshare;

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
public class ProfitSharingReturnOrderResponse extends BaseResponse {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("out_return_no")
    private String outReturnNo;
    @JsonProperty("return_mchid")
    private String returnMchid;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("return_no")
    private String returnNo;
    @JsonProperty("result")
    private String result;
    @JsonProperty("fail_reason")
    private String failReason;
    @JsonProperty("finish_time")
    private String finishTime;
}
