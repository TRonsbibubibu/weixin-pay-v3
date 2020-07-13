package work.trons.library.weixinpay.beans.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryRefundResponse extends BaseResponse {
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("user_received_account")
    private String userReceivedAccount;
    @JsonProperty("success_time")
    private String successTime;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("promotion_detail")
    private List<PromotionDetail> promotionDetail;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Amount {
        @JsonProperty("refund")
        private int refund;
        @JsonProperty("payer_refund")
        private int payerRefund;
        @JsonProperty("discount_refund")
        private int discountRefund;
        @JsonProperty("currency")
        private String currency;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionDetail {
        @JsonProperty("promotion_id")
        private String promotionId;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("type")
        private String type;
        @JsonProperty("amount")
        private int amount;
        @JsonProperty("refund_amount")
        private int refundAmount;
    }
}

