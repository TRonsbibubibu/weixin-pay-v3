package work.trons.library.weixinpay.beans.complaint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/29
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteComplaintNotificationResponse extends BaseResponse {
}
