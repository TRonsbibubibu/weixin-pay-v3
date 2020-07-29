package work.trons.library.weixinpay.api.ecommerce;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.ecommerce.subsidy.*;
import work.trons.library.weixinpay.core.PaySetting;

/**
 * 补差API
 *
 * @author liujiawei
 * @date 2020/7/29
 */
public class EcoSubsidyApi extends BaseApi {
    private EcoSubsidyApi(PaySetting setting) {
        super(setting);
    }

    public static EcoSubsidyApi with(PaySetting paySetting) {
        return new EcoSubsidyApi(paySetting);
    }

    /**
     * 请求补差API
     *
     * @param request
     * @return
     */
    public CreateSubsidyResponse createSubsidy(CreateSubsidyRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/subsidies/create";
        return jsonRequest(method, url, request, CreateSubsidyResponse.class);
    }

    /**
     * 请求补差回退API
     *
     * @param request
     * @return
     */
    public ReturnSubsidyResponse returnSubsidy(ReturnSubsidyRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/subsidies/return";
        return jsonRequest(method, url, request, ReturnSubsidyResponse.class);
    }

    /**
     * 取消补差API
     *
     * @param request
     * @return
     */
    public CancelSubsidyResponse cancelSubsidy(CancelSubsidyRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/subsidies/cancel";
        return jsonRequest(method, url, request, CancelSubsidyResponse.class);
    }
}
