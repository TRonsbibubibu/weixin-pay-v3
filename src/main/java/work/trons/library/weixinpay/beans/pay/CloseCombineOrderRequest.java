package work.trons.library.weixinpay.beans.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloseCombineOrderRequest {
    @JsonProperty("combine_appid")
    private String combineAppid;
    @JsonProperty("combine_out_trade_no")
    private String combineOutTradeNo;
    @JsonProperty("sub_orders")
    private String subOrders;

    @NoArgsConstructor
    @Data
    public static class SubOrders {
        @JsonProperty("mchid")
        private String mchid;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("sub_mchid")
        private String subMchid;
    }
}
