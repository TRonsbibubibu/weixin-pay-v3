package work.trons.library.weixinpay.beans;

import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
public class BaseResponse {
    private String code;
    private String message;

    public boolean isSuccess() {
        return code == null;
    }
}
