package work.trons.library.weixinpay.api.pay;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.CallbackMessage;
import work.trons.library.weixinpay.beans.pay.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.JsonUtils;
import work.trons.library.weixinpay.utils.WxUtils;

/**
 * 普通支付（直连模式)
 *
 * @author liujiawei
 * @date 2020/7/11
 */
public class PayApi extends BaseApi {
    private PayApi(PaySetting setting) {
        super(setting);
    }

    public static PayApi with(PaySetting setting) {
        return new PayApi(setting);
    }

    /**
     * APP下单API
     *
     * @param request
     * @return
     */
    public PayResponse app(PayRequest request) {
        String method = "POST";
        String url = "/v3/pay/transactions/app";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * JSAPI下单API
     *
     * @param request
     * @return
     */
    public PayResponse jsapi(PayRequest request) {
        String method = "POST";
        String url = "/v3/pay/transactions/jsapi";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * Native下单API
     *
     * @param request
     * @return
     */
    public PayResponse native_(PayRequest request) {
        String method = "POST";
        String url = "/v3/pay/transactions/native";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * H5下单API
     *
     * @param request
     * @return
     */
    public PayResponse h5(PayRequest request) {
        String method = "POST";
        String url = "/v3/pay/transactions/h5";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * 微信支付订单号查询
     *
     * @param transactionId
     * @return
     */
    public QueryOrderResponse queryOrderByTransactionId(String transactionId) {
        String method = "GET";
        String url = String.format("/v3/pay/transactions/id/%s?mchid=%s", transactionId, setting.getMchId());
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }

    /**
     * 商户订单号查询
     *
     * @param outTradeNo
     * @return
     */
    public QueryOrderResponse queryOrderByOutTradeNo(String outTradeNo) {
        String method = "GET";
        String url = String.format("/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, setting.getMchId());
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }

    /**
     * 关单API
     *
     * @param outTradeNo
     * @return
     */
    public CloseOrderResponse closeOrder(String outTradeNo) {
        String method = "POST";
        String url = String.format("/v3/pay/transactions/out-trade-no/%s/close?mchid=%s", outTradeNo, setting.getMchId());
        return jsonRequest(method, url, null, CloseOrderResponse.class);
    }

    /**
     * 支付通知API
     *
     * @param json
     * @return
     */
    public PayCallback callback(String json) {
        CallbackMessage message = WxUtils.callback(setting, json);
        return JsonUtils.toObject(message.getResource().getDecrypttext(), PayCallback.class);
    }
}
