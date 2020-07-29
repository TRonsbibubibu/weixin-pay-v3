package work.trons.library.weixinpay.api.ecommerce;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.CallbackMessage;
import work.trons.library.weixinpay.beans.ecommerce.profitshare.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.JsonUtils;
import work.trons.library.weixinpay.utils.RSAUtils;
import work.trons.library.weixinpay.utils.StringUtils;
import work.trons.library.weixinpay.utils.WxUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
public class EcoProfitSharingApi extends BaseApi {
    private EcoProfitSharingApi(PaySetting setting) {
        super(setting);
    }

    public static EcoProfitSharingApi with(PaySetting paySetting) {
        return new EcoProfitSharingApi(paySetting);
    }

    /**
     * 请求分账API
     *
     * @param request
     * @return
     */
    public ProfitSharingApplyOrderResponse apply(ProfitSharingApplyOrderRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/profitsharing/orders";
        return jsonRequest(method, url, request, ProfitSharingApplyOrderResponse.class);
    }

    /**
     * 查询分账结果API
     *
     * @param request
     * @return
     */
    public ProfitSharingQueryOrderResponse queryOrder(ProfitSharingQueryOrderRequest request) {
        String method = "GET";
        Map<String, String> querys = new HashMap<>(4);
        querys.put("sub_mchid", request.getSubMchid());
        querys.put("transaction_id", request.getTransactionId());
        querys.put("out_order_no", request.getOutOrderNo());
        String url = String.format("/v3/ecommerce/profitsharing/orders?%s", StringUtils.toQuery(querys));
        return jsonRequest(method, url, null, ProfitSharingQueryOrderResponse.class);
    }

    /**
     * 请求分账回退API
     *
     * @param request
     * @return
     */
    public ProfitSharingReturnOrderResponse returnOrder(ProfitSharingReturnOrderRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/profitsharing/returnorders";
        return jsonRequest(method, url, request, ProfitSharingReturnOrderResponse.class);
    }

    /**
     * 查询分账回退结果API
     *
     * @param request
     * @return
     */
    public ProfitSharingReturnOrderResponse queryReturnOrder(ProfitSharingQueryReturnOrderRequest request) {
        String method = "GET";
        Map<String, String> querys = new HashMap<>(4);
        querys.put("sub_mchid", request.getSubMchid());
        querys.put("out_return_no", request.getOutReturnNo());
        if (request.getOrderId() != null) {
            querys.put("order_id", request.getOrderId());
        }
        if (request.getOutOrderNo() != null) {
            querys.put("out_order_no", request.getOutOrderNo());
        }
        String url = String.format("/v3/ecommerce/profitsharing/returnorders?%s", StringUtils.toQuery(querys));
        return jsonRequest(method, url, null, ProfitSharingReturnOrderResponse.class);
    }

    /**
     * 完结分账API
     *
     * @param request
     * @return
     */
    public ProfitSharingFinishOrderResponse finishOrder(ProfitSharingFinishOrderRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/profitsharing/finish-order";
        return jsonRequest(method, url, request, ProfitSharingFinishOrderResponse.class);
    }

    /**
     * 添加分账接收方API
     *
     * @param request
     * @return
     */
    public ProfitSharingReceiverResponse addReceiver(ProfitSharingAddReceiverRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/profitsharing/receivers/add";
        if (request.getEncryptedName() != null) {
            request.setEncryptedName(RSAUtils.encrypt(request.getEncryptedName(), setting.getPlatformPublicKey()));
        }
        return jsonRequest(method, url, request, ProfitSharingReceiverResponse.class);
    }

    /**
     * 添加分账接收方API
     *
     * @param request
     * @return
     */
    public ProfitSharingReceiverResponse deleteReceiver(ProfitSharingDeleteReceiverRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/profitsharing/receivers/delete";
        return jsonRequest(method, url, request, ProfitSharingReceiverResponse.class);
    }

    /**
     * 分账动账通知API
     *
     * @param json
     * @return
     */
    public ProfitSharingCallback callback(String json) {
        CallbackMessage callback = WxUtils.callback(setting, json);
        String ciphertext = callback.getResource().getCiphertext();
        return JsonUtils.toObject(ciphertext, ProfitSharingCallback.class);
    }
}
