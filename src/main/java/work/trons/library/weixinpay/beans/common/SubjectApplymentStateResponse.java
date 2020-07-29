package work.trons.library.weixinpay.beans.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectApplymentStateResponse extends BaseResponse {
    @JsonProperty("authorize_state")
    private String authorizeState;
}
