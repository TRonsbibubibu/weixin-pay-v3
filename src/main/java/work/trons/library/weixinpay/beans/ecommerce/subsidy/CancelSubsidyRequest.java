package work.trons.library.weixinpay.beans.ecommerce.subsidy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/29
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelSubsidyRequest {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("description")
    private String description;
}


