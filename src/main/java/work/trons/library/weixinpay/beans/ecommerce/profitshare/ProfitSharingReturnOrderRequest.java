package work.trons.library.weixinpay.beans.ecommerce.profitshare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfitSharingReturnOrderRequest {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("out_return_no")
    private String outReturnNo;
    @JsonProperty("return_mchid")
    private String returnMchid;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("description")
    private String description;
}
