package work.trons.library.weixinpay.api.pay;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.pay.CloseCombineOrderRequest;
import work.trons.library.weixinpay.beans.pay.CombinePayRequest;
import work.trons.library.weixinpay.beans.pay.PayResponse;
import work.trons.library.weixinpay.beans.pay.QueryCombineOrderResponse;
import work.trons.library.weixinpay.core.PaySetting;

/**
 * @author liujiawei
 * @date 2020/6/19
 */
public class CombineApi extends BaseApi {

    private CombineApi(PaySetting setting) {
        super(setting);
    }

    public static CombineApi with(PaySetting setting) {
        return new CombineApi(setting);
    }

    public PayResponse app(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/app";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    public PayResponse jsapi(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/jsapi";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    public PayResponse h5(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/h5";
        request.setCombinePayerInfo(null);
        if (request.getSceneInfo() == null || request.getSceneInfo().getH5Info() == null) {
            throw new IllegalArgumentException("场景信息或者H5场景信息不能为空");
        }
        return jsonRequest(method, url, request, PayResponse.class);
    }

    public PayResponse native_(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/native";
        request.setCombinePayerInfo(null);
        return jsonRequest(method, url, request, PayResponse.class);
    }

    public QueryCombineOrderResponse queryOrder(String combineOutTradeNo) {
        String method = "GET";
        String url = String.format("v3/combine-transactions/out-trade-no/%s", combineOutTradeNo);
        return jsonRequest(method, url, null, QueryCombineOrderResponse.class);
    }

    public QueryCombineOrderResponse closeOrder(String combineOutTradeNo, CloseCombineOrderRequest request) {
        String method = "POST";
        String url = String.format("v3/combine-transactions/out-trade-no/%s/close", combineOutTradeNo);
        return jsonRequest(method, url, null, QueryCombineOrderResponse.class);
    }
}
