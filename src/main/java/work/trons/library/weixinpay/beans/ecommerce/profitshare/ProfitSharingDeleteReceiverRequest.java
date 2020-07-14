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
public class ProfitSharingDeleteReceiverRequest {
    @JsonProperty("appid")
    private String appid;
    @JsonProperty("type")
    private String type;
    @JsonProperty("account")
    private String account;
}
