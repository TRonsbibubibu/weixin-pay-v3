package work.trons.library.weixinpay.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
public class BaseResponse {
    private String code;
    private String message;

    @JsonIgnore
    public boolean isSuccess() {
        return code == null;
    }
}
