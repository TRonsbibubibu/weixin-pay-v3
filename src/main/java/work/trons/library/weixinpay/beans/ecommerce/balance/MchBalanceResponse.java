package work.trons.library.weixinpay.beans.ecommerce.balance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MchBalanceResponse extends BaseResponse {
    @JsonProperty("available_amount")
    private int availableAmount;
    @JsonProperty("pending_amount")
    private int pendingAmount;
}
