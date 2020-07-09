package work.trons.library.weixinpay.utils;

import lombok.SneakyThrows;
import work.trons.library.weixinpay.core.PaySetting;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
public class WxUtils {
    @SneakyThrows
    public static boolean verify(PaySetting paySetting, String sign, String timestamp, String nonceStr, String body) {
        StringBuilder builder = new StringBuilder()
                .append(timestamp).append('\n')
                .append(nonceStr).append('\n')
                .append(body).append('\n');

        return RSAUtils.verify(sign, paySetting.getMchPublicKey(), builder.toString(), paySetting.getSignatureAlgorithm());
    }
}
