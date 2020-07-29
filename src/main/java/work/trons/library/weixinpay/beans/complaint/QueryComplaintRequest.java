package work.trons.library.weixinpay.beans.complaint;

import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/29
 */
@Data
@Builder
public class QueryComplaintRequest {
    private Integer limit;
    private Integer offset;
    private String beginDate;
    private String endDate;
    private String subMchId;
}
