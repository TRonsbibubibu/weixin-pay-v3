package work.trons.library.weixinpay.beans.partnerpay;

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
public class PartnerPayCallback {
    @JsonProperty("sp_appid")
    private String spAppid;
    @JsonProperty("sp_mchid")
    private String spMchid;
    @JsonProperty("sub_appid")
    private String subAppid;
    @JsonProperty("sub_mchid")
    private String subMchid;
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
        @JsonProperty("sp_openid")
        private String spOpenid;
        @JsonProperty("sub_openid")
        private String subOpenid;
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
        @JsonProperty("amount")
        private int amount;
        @JsonProperty("wechatpay_contribute")
        private int wechatpayContribute;
        @JsonProperty("coupon_id")
        private String couponId;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("merchant_contribute")
        private int merchantContribute;
        @JsonProperty("name")
        private String name;
        @JsonProperty("other_contribute")
        private int otherContribute;
        @JsonProperty("currency")
        private String currency;
        @JsonProperty("type")
        private String type;
        @JsonProperty("stock_id")
        private String stockId;
        @JsonProperty("goods_detail")
        private List<GoodsDetail> goodsDetail;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class GoodsDetail {
            @JsonProperty("goods_remark")
            private String goodsRemark;
            @JsonProperty("quantity")
            private int quantity;
            @JsonProperty("discount_amount")
            private int discountAmount;
            @JsonProperty("goods_id")
            private String goodsId;
            @JsonProperty("unit_price")
            private int unitPrice;
        }
    }
}
