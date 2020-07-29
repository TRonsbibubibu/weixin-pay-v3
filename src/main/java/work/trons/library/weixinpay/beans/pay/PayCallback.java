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
public class PayCallback {
    @JsonProperty("appid")
    private String appid;
    @JsonProperty("mchid")
    private String mchid;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("trade_type")
    private String tradeType;
    @JsonProperty("trade_state")
    private String tradeState;
    @JsonProperty("trade_state_desc")
    private String tradeStateDesc;
    @JsonProperty("bank_type")
    private String bankType;
    @JsonProperty("attach")
    private String attach;
    @JsonProperty("success_time")
    private String successTime;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;
    @JsonProperty("promotion_detail")
    private List<PromotionDetail> promotionDetail;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Amount {
        @JsonProperty("payer_total")
        private int payerTotal;
        @JsonProperty("total")
        private int total;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("payer_currency")
        private String payerCurrency;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payer {
        @JsonProperty("openid")
        private String openid;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SceneInfo {
        @JsonProperty("device_id")
        private String deviceId;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionDetail {
        @JsonProperty("coupon_id")
        private String couponId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("type")
        private String type;
        @JsonProperty("amount")
        private int amount;
        @JsonProperty("stock_id")
        private String stockId;
        @JsonProperty("wechatpay_contribute")
        private int wechatpayContribute;
        @JsonProperty("merchant_contribute")
        private int merchantContribute;
        @JsonProperty("other_contribute")
        private int otherContribute;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("goods_detail")
        private List<GoodsDetail> goodsDetail;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class GoodsDetail {
            @JsonProperty("goods_id")
            private String goodsId;
            @JsonProperty("quantity")
            private int quantity;
            @JsonProperty("unit_price")
            private int unitPrice;
            @JsonProperty("discount_amount")
            private int discountAmount;
            @JsonProperty("goods_remark")
            private String goodsRemark;
        }
    }
}
