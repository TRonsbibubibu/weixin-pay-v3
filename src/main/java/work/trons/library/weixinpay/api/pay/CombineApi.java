package work.trons.library.weixinpay.api.pay;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.CallbackMessage;
import work.trons.library.weixinpay.beans.pay.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.JsonUtils;
import work.trons.library.weixinpay.utils.WxUtils;

/**
 * 合单支付API
 *
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

    /**
     * 合单下单-APP支付API
     *
     * @param request
     * @return
     */
    public PayResponse app(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/app";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * 合单下单-JSAPI支付API
     *
     * @param request
     * @return
     */
    public PayResponse jsapi(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/jsapi";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * 合单下单-H5支付API
     *
     * @param request
     * @return
     */
    public PayResponse h5(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/h5";
        request.setCombinePayerInfo(null);
        if (request.getSceneInfo() == null || request.getSceneInfo().getH5Info() == null) {
            throw new IllegalArgumentException("场景信息或者H5场景信息不能为空");
        }
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * 合单下单-Native支付API
     *
     * @param request
     * @return
     */
    public PayResponse native_(CombinePayRequest request) {
        String method = "POST";
        String url = "/v3/combine-transactions/native";
        request.setCombinePayerInfo(null);
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * 合单查询订单API
     *
     * @param combineOutTradeNo
     * @return
     */
    public QueryCombineOrderResponse queryOrder(String combineOutTradeNo) {
        String method = "GET";
        String url = String.format("/v3/combine-transactions/out-trade-no/%s", combineOutTradeNo);
        return jsonRequest(method, url, null, QueryCombineOrderResponse.class);
    }

    /**
     * 合单关闭订单API
     *
     * @param combineOutTradeNo
     * @param request
     * @return
     */
    public QueryCombineOrderResponse closeOrder(String combineOutTradeNo, CloseCombineOrderRequest request) {
        String method = "POST";
        String url = String.format("/v3/combine-transactions/out-trade-no/%s/close", combineOutTradeNo);
        return jsonRequest(method, url, null, QueryCombineOrderResponse.class);
    }

    /**
     * 支付通知API
     *
     * @param json
     * @return
     */
    public CombinePayCallback callback(String json) {
        CallbackMessage message = WxUtils.callback(setting, json);
        return JsonUtils.toObject(message.getResource().getDecrypttext(), CombinePayCallback.class);
    }
}
