package work.trons.library.weixinpay.beans.ecommerce.subsidy;

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
public class ReturnSubsidyResponse extends BaseResponse {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("subsidy_refund_id")
    private String subsidyRefundId;
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("result")
    private String result;
    @JsonProperty("success_time")
    private String successTime;
}
