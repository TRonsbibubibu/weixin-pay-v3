package work.trons.library.weixinpay.beans.submch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ModifySettlementResponse extends BaseResponse {
}
