package work.trons.library.weixinpay.beans.ecommerce.refund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplyRefundResponse extends BaseResponse {
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("out_refund_no")
    private String outRefundNo;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("promotion_detail")
    private List<PromotionDetail> promotionDetail;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Amount {
        @JsonProperty("refund")
        private Integer refund;
        @JsonProperty("payer_refund")
        private Integer payerRefund;
        @JsonProperty("discount_refund")
        private Integer discountRefund;
        @JsonProperty("currency")
        private String currency;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionDetail {
        @JsonProperty("promotion_id")
        private String promotionId;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("type")
        private String type;
        @JsonProperty("amount")
        private Integer amount;
        @JsonProperty("refund_amount")
        private Integer refundAmount;
    }
}
