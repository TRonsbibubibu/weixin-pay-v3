package work.trons.library.weixinpay.api.ecommerce;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.CallbackMessage;
import work.trons.library.weixinpay.beans.ecommerce.ApplyRefundRequest;
import work.trons.library.weixinpay.beans.ecommerce.ApplyRefundResponse;
import work.trons.library.weixinpay.beans.ecommerce.QueryRefundResponse;
import work.trons.library.weixinpay.beans.ecommerce.RefundCallback;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.JsonUtils;
import work.trons.library.weixinpay.utils.WxUtils;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
public class RefundApi extends BaseApi {
    private RefundApi(PaySetting setting) {
        super(setting);
    }

    public static RefundApi with(PaySetting paySetting) {
        return new RefundApi(paySetting);
    }

    /**
     * 退款申请API
     *
     * @param request
     * @return
     */
    public ApplyRefundResponse applyRefund(ApplyRefundRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/refunds/apply";
        return jsonRequest(method, url, request, ApplyRefundResponse.class);
    }

    /**
     * 通过微信支付退款单号查询退款
     *
     * @param subMchid
     * @param refundId
     * @return
     */
    public QueryRefundResponse queryRefundByRefundId(String subMchid, Long refundId) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/refunds/id/%s?sub_mchid=%s", refundId, subMchid);
        return jsonRequest(method, url, null, QueryRefundResponse.class);
    }

    /**
     * 通过商户退款单号查询退款
     *
     * @param subMchid
     * @param outRefundNo
     * @return
     */
    public QueryRefundResponse queryRefundByOutRefundId(String subMchid, String outRefundNo) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/applyments/out-request-no/%s?sub_mchid=%s", outRefundNo, subMchid);
        return jsonRequest(method, url, null, QueryRefundResponse.class);
    }

    /**
     * 退款结果通知API
     *
     * @param json
     * @return
     */
    public RefundCallback callback(String json) {
        CallbackMessage message = WxUtils.callback(setting, json);
        return JsonUtils.toObject(message.getResource().getDecrypttext(), RefundCallback.class);
    }
}
