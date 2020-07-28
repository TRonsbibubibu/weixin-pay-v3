package work.trons.library.weixinpay.beans.ecommerce.profitshare;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfitSharingQueryOrderResponse extends BaseResponse {
}
