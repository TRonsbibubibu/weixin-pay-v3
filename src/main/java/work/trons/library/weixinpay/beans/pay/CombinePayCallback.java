package work.trons.library.weixinpay.beans.pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinePayCallback {
    @JsonProperty("combine_appid")
    private String combineAppid;
    @JsonProperty("combine_mchid")
    private String combineMchid;
    @JsonProperty("combine_out_trade_no")
    private String combineOutTradeNo;
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;
    @JsonProperty("sub_orders")
    private List<SubOrders> subOrders;
    @JsonProperty("combine_payer_info")
    private CombinePayerInfo combinePayerInfo;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SceneInfo {
        @JsonProperty("device_id")
        private String deviceId;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CombinePayerInfo {
        @JsonProperty("openid")
        private String openid;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubOrders {
        @JsonProperty("mchid")
        private String mchid;
        @JsonProperty("trade_type")
        private String tradeType;
        @JsonProperty("trade_state")
        private String tradeState;
        @JsonProperty("bank_type")
        private String bankType;
        @JsonProperty("attach")
        private String attach;
        @JsonProperty("success_time")
        private String successTime;
        @JsonProperty("transaction_id")
        private String transactionId;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("sub_mchid")
        private String subMchid;
        @JsonProperty("amount")
        private Amount amount;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Amount {
            @JsonProperty("total_amount")
            private Integer totalAmount;
            @JsonProperty("currency")
            private String currency;
            @JsonProperty("payer_amount")
            private Integer payerAmount;
            @JsonProperty("payer_currency")
            private String payerCurrency;
        }
    }
}
