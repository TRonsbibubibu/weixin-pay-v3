package work.trons.library.weixinpay.beans.ecommerce.profitshare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfitSharingApplyOrderRequest {
    @JsonProperty("appid")
    private String appid;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("finish")
    private boolean finish;
    @JsonProperty("receivers")
    private List<Receivers> receivers;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Receivers {
        @JsonProperty("type")
        private String type;
        @JsonProperty("receiver_account")
        private String receiverAccount;
        @JsonProperty("amount")
        private int amount;
        @JsonProperty("description")
        private String description;
    }
}
