package work.trons.library.weixinpay.api.pay;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.DownloadBillResponse;
import work.trons.library.weixinpay.beans.bill.FundFlowBillRequest;
import work.trons.library.weixinpay.beans.bill.TradeBillRequest;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.StringUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 账单
 *
 * @author liujiawei
 * @date 2020/7/14
 */
public class BillApi extends BaseApi {
    private BillApi(PaySetting setting) {
        super(setting);
    }

    public static BillApi with(PaySetting paySetting) {
        return new BillApi(paySetting);
    }

    /**
     * 申请交易账单API
     *
     * @param request
     * @return
     */
    public DownloadBillResponse tradeBill(TradeBillRequest request) {
        String method = "GET";
        Map<String, String> querys = new HashMap<>(4);
        querys.put("bill_date", request.getBillDate());
        if (request.getSubMchid() != null) {
            querys.put("sub_mchid", request.getSubMchid());
        }
        if (request.getBillType() != null) {
            querys.put("bill_type", request.getBillType());
        }
        if (request.getTarType() != null) {
            querys.put("tar_type", request.getTarType());
        }
        String url = String.format("/v3/bill/tradebill?%s", StringUtils.toQuery(querys));
        return jsonRequest(method, url, null, DownloadBillResponse.class);
    }

    /**
     * 申请资金账单API
     *
     * @param request
     * @return
     */
    public DownloadBillResponse fundFlowBill(FundFlowBillRequest request) {
        String method = "GET";
        Map<String, String> querys = new HashMap<>(3);
        querys.put("bill_date", request.getBillDate());
        if (request.getAccountType() != null) {
            querys.put("account_type", request.getAccountType());
        }
        if (request.getTarType() != null) {
            querys.put("tar_type", request.getTarType());
        }
        String url = String.format("/v3/bill/fundflowbill?%s", StringUtils.toQuery(querys));
        return jsonRequest(method, url, null, DownloadBillResponse.class);
    }

    public InputStream downloadBill(String url) {
        InputStream inputStream = fileDownload(url.replace("https://api.mch.weixin.qq.com", ""));
        return inputStream;
    }
}
