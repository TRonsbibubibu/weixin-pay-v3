package work.trons.library.weixinpay.beans.ecommerce.refund;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ApplyRefundRequest {

    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("sp_appid")
    private String spAppid;
    @JsonProperty("sub_appid")
    private String subAppid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("notify_url")
    private String notifyUrl;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Builder
    public static class Amount {
        @JsonProperty("refund")
        private Integer refund;
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("currency")
        private String currency;
    }
}
