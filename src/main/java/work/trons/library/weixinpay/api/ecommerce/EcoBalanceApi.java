package work.trons.library.weixinpay.api.ecommerce;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.ecommerce.balance.MchBalanceResponse;
import work.trons.library.weixinpay.beans.ecommerce.balance.SubMchBalanceResponse;
import work.trons.library.weixinpay.core.PaySetting;

/**
 * 电商收付通 余额查询API
 *
 * @author liujiawei
 * @date 2020/7/13
 */
public class EcoBalanceApi extends BaseApi {
    private EcoBalanceApi(PaySetting setting) {
        super(setting);
    }

    public static EcoBalanceApi with(PaySetting paySetting) {
        return new EcoBalanceApi(paySetting);
    }

    public SubMchBalanceResponse querySubMchBalance(String subMchid) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/fund/balance/%s", subMchid);
        return jsonRequest(method, url, null, SubMchBalanceResponse.class);
    }

    public SubMchBalanceResponse querySubMchEnddayBalance(String subMchid, String date) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/fund/enddaybalance/%s?date=%s", subMchid, date);
        return jsonRequest(method, url, null, SubMchBalanceResponse.class);
    }

    public MchBalanceResponse queryMchBalance(String accountType) {
        String method = "GET";
        String url = String.format("/v3/merchant/fund/balance/%s", accountType);
        return jsonRequest(method, url, null, MchBalanceResponse.class);
    }

    public MchBalanceResponse queryMchEnddayBalance(String accountType, String date) {
        String method = "GET";
        String url = String.format("/v3/merchant/fund/dayendbalance//%s?date=%s", accountType, date);
        return jsonRequest(method, url, null, MchBalanceResponse.class);
    }
}
