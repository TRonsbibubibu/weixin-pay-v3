package work.trons.library.weixinpay.beans.ecommerce.profitshare;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfitSharingQueryOrderResponse extends BaseResponse {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("receivers")
    private Receivers receivers;
    @JsonProperty("close_reason")
    private String closeReason;
    @JsonProperty("finish_amount")
    private Integer finishAmount;
    @JsonProperty("finish_description")
    private String finishDescription;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Receivers {
        @JsonProperty("receiver_mchid")
        private String receiverMchid;
        @JsonProperty("amount")
        private Integer amount;
        @JsonProperty("description")
        private String description;
        @JsonProperty("result")
        private String result;
        @JsonProperty("finish_time")
        private String finishTime;
        @JsonProperty("fail_reason")
        private String failReason;
        @JsonProperty("type")
        private String type;
        @JsonProperty("receiver_account")
        private String receiverAccount;
    }
}
