package work.trons.library.weixinpay.beans.ecommerce.profitshare;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProfitSharingCallback {
    @JsonProperty("mchid")
    private String mchid;
    @JsonProperty("sp_mchid")
    private String spMchid;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("success_time")
    private String successTime;
    @JsonProperty("receivers")
    private List<Receivers> receivers;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Receivers {
        @JsonProperty("type")
        private String type;
        @JsonProperty("account")
        private String account;
        @JsonProperty("amount")
        private String amount;
        @JsonProperty("description")
        private String description;
    }
}
