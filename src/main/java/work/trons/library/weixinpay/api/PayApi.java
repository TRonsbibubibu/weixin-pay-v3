package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.PayResponse;
import work.trons.library.weixinpay.beans.pay.CloseOrderResponse;
import work.trons.library.weixinpay.beans.pay.PayRequest;
import work.trons.library.weixinpay.beans.pay.QueryOrderResponse;
import work.trons.library.weixinpay.core.PaySetting;

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
     * @param subMchid
     * @param transactionId
     * @return
     */
    public QueryOrderResponse queryOrderByTransactionId(String subMchid, String transactionId) {
        String method = "GET";
        String url = String.format("v3/pay/transactions/id/%s?mchid=%s", transactionId, subMchid);
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }

    /**
     * 商户订单号查询
     *
     * @param subMchid
     * @param outTradeNo
     * @return
     */
    public QueryOrderResponse queryOrderByOutTradeNo(String subMchid, String outTradeNo) {
        String method = "GET";
        String url = String.format("/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, subMchid);
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }

    public CloseOrderResponse closeOrder(String subMchid, String outTradeNo) {
        String method = "POST";
        String url = String.format("/v3/pay/transactions/out-trade-no/%s/close?mchid=%s", outTradeNo, subMchid);
        return jsonRequest(method, url, null, CloseOrderResponse.class);
    }
}
