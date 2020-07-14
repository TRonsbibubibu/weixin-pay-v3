package work.trons.library.weixinpay.beans.ecommerce.refund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundCallback {
    @JsonProperty("sp_mchid")
    private String spMchid;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    @JsonProperty("status")
    private String status;
    @JsonProperty("success_time")
    private String successTime;
    @JsonProperty("user_received_account")
    private String userReceivedAccount;
    @JsonProperty("amount")
    private Amount amount;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Amount {
        @JsonProperty("total")
        private int total;
        @JsonProperty("refund")
        private int refund;
        @JsonProperty("payer_total")
        private int payerTotal;
        @JsonProperty("payer_refund")
        private int payerRefund;
    }
}
