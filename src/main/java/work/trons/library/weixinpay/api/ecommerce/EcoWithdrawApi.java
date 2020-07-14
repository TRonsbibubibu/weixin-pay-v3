package work.trons.library.weixinpay.api.ecommerce;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.DownloadBillResponse;
import work.trons.library.weixinpay.beans.ecommerce.withdraw.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
public class EcoWithdrawApi extends BaseApi {
    private EcoWithdrawApi(PaySetting setting) {
        super(setting);
    }

    public static EcoWithdrawApi with(PaySetting paySetting) {
        return new EcoWithdrawApi(paySetting);
    }

    /**
     * 二级商户余额提现API
     *
     * @param request
     * @return
     */
    public SubMchWithdrawResponse subMchWithdraw(SubMchWithdrawRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/fund/withdraw";
        return jsonRequest(method, url, request, SubMchWithdrawResponse.class);
    }

    /**
     * 二级商户查询提现状态-微信支付提现单号
     *
     * @param subMchid
     * @param withdrawId
     * @return
     */
    public QuerySubMchWithdrawResponse querySubMchByWithdrawId(String subMchid, String withdrawId) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/fund/withdraw/%s?sub_mchid=%s", withdrawId, subMchid);
        return jsonRequest(method, url, null, QuerySubMchWithdrawResponse.class);
    }

    /**
     * 二级商户查询提现状态-商户提现单号
     *
     * @param subMchid
     * @param outRequestNo
     * @return
     */
    public QuerySubMchWithdrawResponse querySubMchByOutRequestNo(String subMchid, String outRequestNo) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/fund/withdraw/out-request-no/%s?sub_mchid=%s", outRequestNo, subMchid);
        return jsonRequest(method, url, null, QuerySubMchWithdrawResponse.class);
    }

    /**
     * 电商平台提现API
     *
     * @param request
     * @return
     */
    public MchWithdrawResponse mchWithdraw(MchWithdrawRequest request) {
        String method = "POST";
        String url = "/v3/merchant/fund/withdraw";
        return jsonRequest(method, url, null, MchWithdrawResponse.class);
    }

    /**
     * 电商平台查询提现状态-微信支付提现单号
     *
     * @param withdrawId
     * @return TODO 2020.05.14文档错误,API待验证
     */
    public QueryMchWithdrawResponse queryMchByWithdrawId(String withdrawId) {
        String method = "GET";
        String url = String.format("/v3/merchant/fund/withdraw/%s", withdrawId);
        return jsonRequest(method, url, null, QueryMchWithdrawResponse.class);
    }

    /**
     * 电商平台查询提现状态-商户提现单号
     *
     * @param outRequestNo
     * @return
     */
    public QueryMchWithdrawResponse queryMchByOutRequestNo(String outRequestNo) {
        String method = "GET";
        String url = String.format("/v3/merchant/fund/withdraw/out-request-no/%s", outRequestNo);
        return jsonRequest(method, url, null, QueryMchWithdrawResponse.class);
    }

    /**
     * 按日下载提现异常文件API
     *
     * @param billType
     * @param billDate
     * @param tarType
     * @return
     */
    public DownloadBillResponse downloadWithdrawBill(String billType, String billDate, String tarType) {
        String method = "GET";
        Map<String, String> querys = new HashMap<>(2);
        querys.put("bill_date", billDate);
        if (tarType != null) {
            querys.put("tar_type", tarType);
        }
        String url = String.format("/v3/merchant/fund/withdraw/bill-type/%s?%s", billType, StringUtils.toQuery(querys));
        return jsonRequest(method, url, null, DownloadBillResponse.class);
    }
}
