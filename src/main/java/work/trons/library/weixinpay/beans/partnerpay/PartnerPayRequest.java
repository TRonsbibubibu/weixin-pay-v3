package work.trons.library.weixinpay.beans.partnerpay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnerPayRequest {
    @JsonProperty("sp_appid")
    private String spAppid;
    @JsonProperty("sp_mchid")
    private String spMchid;
    @JsonProperty("sub_appid")
    private String subAppid;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("description")
    private String description;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("time_expire")
    private String timeExpire;
    @JsonProperty("attach")
    private String attach;
    @JsonProperty("notify_url")
    private String notifyUrl;
    @JsonProperty("goods_tag")
    private String goodsTag;
    @JsonProperty("settle_info")
    private SettleInfo settleInfo;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("detail")
    private Detail detail;
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SettleInfo {
        @JsonProperty("profit_sharing")
        private Boolean profitSharing;
        @JsonProperty("subsidy_amount")
        private Long subsidyAmount;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Amount {
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("currency")
        private String currency;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Payer {
        @JsonProperty("sp_openid")
        private String spOpenid;
        @JsonProperty("sub_openid")
        private String subOpenid;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Detail {
        @JsonProperty("cost_price")
        private Integer costPrice;
        @JsonProperty("invoice_id")
        private String invoiceId;
        @JsonProperty("goods_detail")
        private List<GoodsDetail> goodsDetail;

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class GoodsDetail {
            @JsonProperty("merchant_goods_id")
            private String merchantGoodsId;
            @JsonProperty("wechatpay_goods_id")
            private String wechatpayGoodsId;
            @JsonProperty("goods_name")
            private String goodsName;
            @JsonProperty("quantity")
            private Integer quantity;
            @JsonProperty("unit_price")
            private Integer unitPrice;
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SceneInfo {
        @JsonProperty("payer_client_ip")
        private String payerClientIp;
        @JsonProperty("device_id")
        private String deviceId;
        @JsonProperty("store_info")
        private StoreInfo storeInfo;
        @JsonProperty("h5_info")
        private H5Info h5Info;

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class StoreInfo {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
            @JsonProperty("area_code")
            private String areaCode;
            @JsonProperty("address")
            private String address;
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class H5Info {
            @JsonProperty("type")
            private String type;
            @JsonProperty("app_name")
            private String appName;
            @JsonProperty("app_url")
            private String appUrl;
            @JsonProperty("bundle_id")
            private String bundleId;
            @JsonProperty("package_name")
            private String packageName;
        }
    }
}
