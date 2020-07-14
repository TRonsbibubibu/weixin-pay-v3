package work.trons.library.weixinpay.api.ecommerce;

import work.trons.library.weixinpay.api.BaseApi;
import work.trons.library.weixinpay.beans.ecommerce.applyment.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.RSAUtils;
import work.trons.library.weixinpay.utils.StringUtils;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
public class EcoApplymentApi extends BaseApi {

    private EcoApplymentApi(PaySetting setting) {
        super(setting);
    }

    public static EcoApplymentApi with(PaySetting setting) {
        return new EcoApplymentApi(setting);
    }

    /**
     * 二级商户进件API
     *
     * @param request
     * @return
     */
    public SubmitEcoApplymentResponse submitApplyment(SubmitEcoApplymentRequest request) {
        String method = "POST";
        String url = "/v3/ecommerce/applyments/";
        if (request.getIdCardInfo() != null) {
            SubmitEcoApplymentRequest.IdCardInfo idCardInfo = request.getIdCardInfo();
            idCardInfo.setIdCardName(RSAUtils.encrypt(idCardInfo.getIdCardName(), setting.getPlatformPublicKey()));
            idCardInfo.setIdCardNumber(RSAUtils.encrypt(idCardInfo.getIdCardNumber(), setting.getPlatformPublicKey()));
        }
        if (request.getAccountInfo() != null) {
            SubmitEcoApplymentRequest.AccountInfo accountInfo = request.getAccountInfo();
            accountInfo.setAccountName(RSAUtils.encrypt(accountInfo.getAccountName(), setting.getPlatformPublicKey()));
            accountInfo.setAccountNumber(RSAUtils.encrypt(accountInfo.getAccountNumber(), setting.getPlatformPublicKey()));
        }

        SubmitEcoApplymentRequest.ContactInfo contactInfo = request.getContactInfo();
        contactInfo.setContactName(RSAUtils.encrypt(contactInfo.getContactName(), setting.getPlatformPublicKey()));
        contactInfo.setContactIdCardNumber(RSAUtils.encrypt(contactInfo.getContactIdCardNumber(), setting.getPlatformPublicKey()));
        contactInfo.setMobilePhone(RSAUtils.encrypt(contactInfo.getMobilePhone(), setting.getPlatformPublicKey()));
        contactInfo.setContactEmail(RSAUtils.encrypt(contactInfo.getContactEmail(), setting.getPlatformPublicKey()));
        return jsonRequest(method, url, request, SubmitEcoApplymentResponse.class);
    }

    /**
     * 通过申请单ID查询申请状态
     *
     * @param applymentId
     * @return
     */
    public GetEcoApplymentResponse getApplymentByApplymentId(String applymentId) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/applyments/%s", applymentId);
        return jsonRequest(method, url, null, GetEcoApplymentResponse.class);
    }

    /**
     * 通过业务申请编号查询申请状态
     *
     * @param outRequestNo
     * @return
     */
    public GetEcoApplymentResponse getApplymentByOutRequestNo(String outRequestNo) {
        String method = "GET";
        String url = String.format("/v3/ecommerce/applyments/out-request-no/%s", outRequestNo);
        GetEcoApplymentResponse response = jsonRequest(method, url, null, GetEcoApplymentResponse.class);
        if (response.getAccountValidation() != null) {
            GetEcoApplymentResponse.AccountValidation validation = response.getAccountValidation();
            if (!StringUtils.isBlank(validation.getAccountName())) {
                validation.setAccountName(RSAUtils.decrypt(validation.getAccountName(), setting.getMchPrivateKey()));
            }
            if (!StringUtils.isBlank(validation.getAccountNo())) {
                validation.setAccountNo(RSAUtils.decrypt(validation.getAccountNo(), setting.getMchPrivateKey()));
            }
        }
        return response;
    }

    /**
     * 查询结算账户API
     *
     * @param subMchid
     * @return
     */
    public GetEcoSettlementResponse getSettlement(String subMchid) {
        String method = "GET";
        String url = String.format("/v3/apply4sub/sub_merchants/%s/settlement", subMchid);
        return jsonRequest(method, url, null, GetEcoSettlementResponse.class);
    }

    /**
     * 修改结算帐号API
     *
     * @param subMchid
     * @param request
     * @return
     */
    public ModifyEcoSettlementResponse modifySettlement(String subMchid, ModifyEcoSettlementRequest request) {
        String method = "POST";
        request.setAccountNumber(RSAUtils.encrypt(request.getAccountNumber(), setting.getPlatformPublicKey()));
        String url = String.format("/v3/apply4sub/sub_merchants/%s/modify-settlement", subMchid);
        return jsonRequest(method, url, request, ModifyEcoSettlementResponse.class);
    }
}
