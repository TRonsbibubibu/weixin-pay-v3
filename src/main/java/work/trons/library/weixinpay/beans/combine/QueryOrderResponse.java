package work.trons.library.weixinpay.beans.combine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.trons.library.weixinpay.beans.BaseResponse;

import java.util.List;


/**
 * @author liujiawei
 * @date 2020/6/20
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryOrderResponse extends BaseResponse {
    @JsonProperty("combine_appid")
    private String combineAppid;
    @JsonProperty("combine_mchid")
    private String combineMchid;
    @JsonProperty("combine_payer_info")
    private CombinePayerInfo combinePayerInfo;
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;
    @JsonProperty("combine_out_trade_no")
    private String combineOutTradeNo;
    @JsonProperty("sub_orders")
    private List<SubOrders> subOrders;

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CombinePayerInfo {
        @JsonProperty("openid")
        private String openid;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SceneInfo {
        @JsonProperty("device_id")
        private String deviceId;
    }

    @NoArgsConstructor
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
        @JsonProperty("amount")
        private Amount amount;
        @JsonProperty("transaction_id")
        private String transactionId;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("sub_mchid")
        private String subMchid;

        @NoArgsConstructor
        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Amount {
            @JsonProperty("total_amount")
            private int totalAmount;
            @JsonProperty("payer_amount")
            private int payerAmount;
            @JsonProperty("currency")
            private String currency;
            @JsonProperty("payer_currency")
            private String payerCurrency;
        }
    }
}
