package work.trons.library.weixinpay.beans.bill;

import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/14
 */
@Data
@Builder
public class FundFlowBillRequest {
    private String billDate;
    private String accountType;
    private String tarType;
}
