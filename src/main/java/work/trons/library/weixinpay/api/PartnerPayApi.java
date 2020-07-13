package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.CallbackMessage;
import work.trons.library.weixinpay.beans.PayResponse;
import work.trons.library.weixinpay.beans.partnerpay.PartnerPayCallback;
import work.trons.library.weixinpay.beans.partnerpay.PartnerPayRequest;
import work.trons.library.weixinpay.beans.pay.CloseOrderResponse;
import work.trons.library.weixinpay.beans.pay.QueryOrderResponse;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.JsonUtils;
import work.trons.library.weixinpay.utils.WxUtils;

/**
 * 普通支付（服务商模式）
 *
 * @author liujiawei
 * @date 2020/7/11
 */
public class PartnerPayApi extends BaseApi {
    private PartnerPayApi(PaySetting setting) {
        super(setting);
    }

    public static PartnerPayApi with(PaySetting setting) {
        return new PartnerPayApi(setting);
    }

    /**
     * APP下单API
     *
     * @param request
     * @return
     */
    public PayResponse app(PartnerPayRequest request) {
        String method = "POST";
        String url = "/v3/pay/partner/transactions/app";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * JSAPI下单API
     *
     * @param request
     * @return
     */
    public PayResponse jsapi(PartnerPayRequest request) {
        String method = "POST";
        String url = "/v3/pay/partner/transactions/jsapi";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * Native下单API
     *
     * @param request
     * @return
     */
    public PayResponse native_(PartnerPayRequest request) {
        String method = "POST";
        String url = "/v3/pay/partner/transactions/native";
        return jsonRequest(method, url, request, PayResponse.class);
    }

    /**
     * H5下单API
     *
     * @param request
     * @return
     */
    public PayResponse h5(PartnerPayRequest request) {
        String method = "POST";
        String url = "/v3/pay/partner/transactions/h5";
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
        String url = String.format("/v3/pay/partner/transactions/id/%s?sp_mchid=%s&sub_mchid=%s",
                transactionId, setting.getMchId(), subMchid);
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
        String url = String.format("/v3/pay/partner/transactions/out-trade-no/%s?sp_mchid=%s&sub_mchid=%s",
                outTradeNo, setting.getMchId(), subMchid);
        return jsonRequest(method, url, null, QueryOrderResponse.class);
    }

    /**
     * 关单API
     *
     * @param subMchid
     * @param outTradeNo
     * @return
     */
    public CloseOrderResponse closeOrder(String subMchid, String outTradeNo) {
        String method = "POST";
        String url = String.format("/v3/pay/partner/transactions/out-trade-no/%s/close?sp_mchid=%s&sub_mchid=%s",
                outTradeNo, setting.getMchId(), subMchid);
        return jsonRequest(method, url, null, CloseOrderResponse.class);
    }

    /**
     * 支付通知API
     *
     * @param json
     * @return
     */
    public PartnerPayCallback callback(String json) {
        CallbackMessage message = WxUtils.callback(setting, json);
        return JsonUtils.toObject(message.getResource().getDecrypttext(), PartnerPayCallback.class);
    }
}
