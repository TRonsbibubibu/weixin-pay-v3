package work.trons.library.weixinpay.api;

import lombok.SneakyThrows;
import work.trons.library.weixinpay.beans.market.PayGiftActivitiesResponse;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.MapUtils;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
public class MarketApi extends BaseApi {
    private MarketApi(PaySetting setting) {
        super(setting);
    }

    public static MarketApi with(PaySetting setting) {
        return new MarketApi(setting);
    }

    @SneakyThrows
    public PayGiftActivitiesResponse payGiftActivities(Integer offset, Integer limit) {
        String method = "GET";
        String url = "/v3/marketing/paygiftactivity/activities?" + queryString(MapUtils.immutable(
                "offset", offset,
                "limit", limit
        ));
        return jsonRequest(method, url, null, PayGiftActivitiesResponse.class);
    }
}
