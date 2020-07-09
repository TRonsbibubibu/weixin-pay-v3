package work.trons.library.weixin.api;

import work.trons.library.weixin.beans.combine.CloseOrderRequest;
import work.trons.library.weixin.beans.combine.CombinePayRequest;
import work.trons.library.weixin.beans.combine.CombinePayResponse;
import work.trons.library.weixin.beans.combine.QueryOrderResponse;
import work.trons.library.weixin.core.PaySetting;

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

    public CombinePayResponse app(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/app";
        return jsonRequest(method, url, request, CombinePayResponse.class);
    }

    public CombinePayResponse jsapi(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/jsapi";
        return jsonRequest(method, url, request, CombinePayResponse.class);
    }

    public CombinePayResponse h5(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/h5";
        request.setCombinePayerInfo(null);
        if (request.getSceneInfo() == null || request.getSceneInfo().getH5Info() == null) {
            throw new IllegalArgumentException("场景信息或者H5场景信息不能为空");
        }
        return jsonRequest(method, url, request, CombinePayResponse.class);
    }

    public CombinePayResponse natives(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/native";
        request.setCombinePayerInfo(null);
        return jsonRequest(method, url, request, CombinePayResponse.class);
    }

    public QueryOrderResponse queryOrder(String combineOutTradeNo) {
        String method = "GET";
        String url = String.format("v3/combine-transactions/out-trade-no/%s", combineOutTradeNo);
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }

    public QueryOrderResponse closeOrder(String combineOutTradeNo, CloseOrderRequest request) {
        String method = "POST";
        String url = String.format("v3/combine-transactions/out-trade-no/%s/close", combineOutTradeNo);
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }
}
