package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.CallbackMessage;
import work.trons.library.weixinpay.beans.complaInteger.QueryComplaintResponse;
import work.trons.library.weixinpay.beans.complaint.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.JsonUtils;
import work.trons.library.weixinpay.utils.MapUtils;
import work.trons.library.weixinpay.utils.StringUtils;
import work.trons.library.weixinpay.utils.WxUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 商业支付投诉API
 *
 * @author liujiawei
 * @date 2020/7/29
 */
public class ComplaintApi extends BaseApi {
    private ComplaintApi(PaySetting setting) {
        super(setting);
    }

    public static ComplaintApi with(PaySetting paySetting) {
        return new ComplaintApi(paySetting);
    }

    /**
     * 查询投诉信息API
     *
     * @param request
     * @return
     */
    public QueryComplaintResponse queryComplaint(QueryComplaintRequest request) {
        String method = "GET";
        Map<String, String> query = new HashMap<>(5);
        if (request.getLimit() != null) {
            query.put("limit", request.getLimit().toString());
        }
        if (request.getOffset() != null) {
            query.put("offset", request.getOffset().toString());
        }
        query.put("begin_date", request.getBeginDate());
        query.put("end_date", request.getEndDate());
        if (request.getSubMchId() != null) {
            query.put("sub_mchid", request.getSubMchId());
        }
        String url = String.format("/v3/merchant-service/complaints?%s", StringUtils.toQuery(query));
        return jsonRequest(method, url, null, QueryComplaintResponse.class);
    }

    /**
     * 创建投诉通知回调API
     *
     * @param url
     * @return
     */
    public CreateComplaintNotificationResponse createComplaintNotification(String url) {
        String method = "POST";
        String _url = "/v3/merchant-service/complaint-notifications";
        return jsonRequest(method, _url, MapUtils.immutable("url", url), CreateComplaintNotificationResponse.class);
    }

    /**
     * 查询投诉通知回调API
     *
     * @return
     */
    public QueryComplaintNotificationResponse queryComplaintNotification() {
        String method = "GET";
        String url = "/v3/merchant-service/complaint-notifications";
        return jsonRequest(method, url, null, QueryComplaintNotificationResponse.class);
    }

    /**
     * 更新投诉通知回调API
     *
     * @param url
     * @return
     */
    public UpdateComplaintNotificationResponse updateComplaintNotification(String url) {
        String method = "PUT";
        String _url = "/v3/merchant-service/complaint-notifications";
        return jsonRequest(method, _url, MapUtils.immutable("url", url), UpdateComplaintNotificationResponse.class);
    }

    /**
     * 删除投诉通知回调API
     *
     * @return
     */
    public DeleteComplaintNotificationResponse deleteComplaintNotification() {
        String method = "DELETE";
        String url = "/v3/merchant-service/complaint-notifications";
        return jsonRequest(method, url, null, DeleteComplaintNotificationResponse.class);
    }

    /**
     * 投诉通知回调API
     *
     * @param json
     * @return
     */
    public ComplaintNotificationCallback callback(String json) {
        CallbackMessage message = WxUtils.callback(setting, json);
        return JsonUtils.toObject(message.getResource().getDecrypttext(), ComplaintNotificationCallback.class);
    }
}
