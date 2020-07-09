package work.trons.library.weixin.beans.combine;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/6/19
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CombinePayRequest {
    @JsonProperty("combine_appid")
    private String combineAppid;
    @JsonProperty("combine_mchid")
    private String combineMchid;
    @JsonProperty("combine_out_trade_no")
    private String combineOutTradeNo;
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;
    @JsonProperty("sub_orders")
    private List<SubOrder> subOrders;
    @JsonProperty("combine_payer_info")
    private CombinePayerInfo combinePayerInfo;
    @JsonProperty("time_start")
    private String timeStart;
    @JsonProperty("time_expire")
    private String timeExpire;
    @JsonProperty("notify_url")
    private String notifyUrl;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CombinePayerInfo {
        @JsonProperty("openid")
        private String openid;
    }

    @Data
    @Builder
    public static class SceneInfo {
        @JsonProperty("device_id")
        private String deviceId;
        @JsonProperty("payer_client_ip")
        private String payerClientIp;
        @JsonProperty("h5_info")
        private H5Info h5Info;
    }

    @Data
    @Builder
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
        private String packageMame;
    }

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
    public static class SubOrder {
        @JsonProperty("mchid")
        private String mchid;
        @JsonProperty("attach")
        private String attach;
        @JsonProperty("amount")
        private Amount amount;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("sub_mchid")
        private String subMcnid;
        @JsonProperty("description")
        private String description;
        @JsonProperty("settle_info")
        private SettleInfo settleInfo;
    }

    @Data
    @Builder
    public static class Amount {
        @JsonProperty("total_amount")
        private Long totalAmount;
        @JsonProperty("currency")
        private String currency;
    }
}
