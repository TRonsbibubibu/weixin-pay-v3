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
public class ProfitSharingReceiverResponse extends BaseResponse {
    @JsonProperty("type")
    private String type;
    @JsonProperty("account")
    private String account;
}
