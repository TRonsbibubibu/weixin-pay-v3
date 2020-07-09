package work.trons.library.weixinpay.beans.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifySettlementResponse extends BaseResponse {
}
