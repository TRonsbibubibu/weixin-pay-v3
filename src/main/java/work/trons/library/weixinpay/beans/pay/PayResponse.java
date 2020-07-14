package work.trons.library.weixinpay.beans.pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayResponse extends BaseResponse {
    @JsonProperty("prepay_id")
    private String prepayId;
}
