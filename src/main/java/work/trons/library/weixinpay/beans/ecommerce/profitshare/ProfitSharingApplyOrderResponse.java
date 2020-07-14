package work.trons.library.weixinpay.beans.ecommerce.profitshare;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProfitSharingApplyOrderResponse extends BaseResponse {
    @JsonProperty("appid")
    private String appid;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_order_no")
    private String outOrderNo;
    @JsonProperty("order_id")
    private String orderId;
}
