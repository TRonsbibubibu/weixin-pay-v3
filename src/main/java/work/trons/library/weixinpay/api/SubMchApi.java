package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.submch.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.RSAUtils;

/**
 * @author liujiawei
 * @date 2020/7/10
 * 特约商户进件
 */
public class SubMchApi extends BaseApi {

    private SubMchApi(PaySetting setting) {
        super(setting);
    }

    public static SubMchApi with(PaySetting setting) {
        return new SubMchApi(setting);
    }

    /**
     * 提交申请单API
     *
     * @param request
     * @return SubmitApplymentResponse
     */
    public SubmitApplymentResponse submitApplyment(SubmitApplymentRequest request) {
        String method = "POST";
        String url = "/v3/applyment4sub/applyment/";
        /**
         * 超级管理员信息
         */
        SubmitApplymentRequest.ContactInfo contactInfo = request.getContactInfo();
        contactInfo.setContactName(RSAUtils.encrypt(contactInfo.getContactName(), setting.getPlatformPublicKey()));
        if (contactInfo.getContactIdNumber() != null) {
            contactInfo.setContactIdNumber(RSAUtils.encrypt(contactInfo.getContactIdNumber(), setting.getPlatformPublicKey()));
        }
        contactInfo.setMobilePhone(RSAUtils.encrypt(contactInfo.getMobilePhone(), setting.getPlatformPublicKey()));
        contactInfo.setContactEmail(RSAUtils.encrypt(contactInfo.getContactEmail(), setting.getPlatformPublicKey()));

        /**
         * 经营者/法人身份证件
         */
        SubmitApplymentRequest.SubjectInfo subjectInfo = request.getSubjectInfo();
        if (subjectInfo.getIdentityInfo() != null) {
            SubmitApplymentRequest.SubjectInfo.IdentityInfo identityInfo = subjectInfo.getIdentityInfo();
            if (identityInfo.getIdCardInfo() != null) {
                SubmitApplymentRequest.SubjectInfo.IdentityInfo.IdCardInfo idCardInfo = identityInfo.getIdCardInfo();
                idCardInfo.setIdCardName(RSAUtils.encrypt(idCardInfo.getIdCardName(), setting.getPlatformPublicKey()));
                idCardInfo.setIdCardNumber(RSAUtils.encrypt(idCardInfo.getIdCardNumber(), setting.getPlatformPublicKey()));
            }
            if (identityInfo.getIdDocInfo() != null) {
                SubmitApplymentRequest.SubjectInfo.IdentityInfo.IdDocInfo idDocInfo = identityInfo.getIdDocInfo();
                idDocInfo.setIdDocName(RSAUtils.encrypt(idDocInfo.getIdDocName(), setting.getPlatformPublicKey()));
                idDocInfo.setIdDocNumber(RSAUtils.encrypt(idDocInfo.getIdDocNumber(), setting.getPlatformPublicKey()));
            }
            if (subjectInfo.getUboInfo() != null) {
                SubmitApplymentRequest.SubjectInfo.UboInfo uboInfo = subjectInfo.getUboInfo();
                uboInfo.setName(RSAUtils.encrypt(uboInfo.getName(), setting.getPlatformPublicKey()));
                uboInfo.setIdNumber(RSAUtils.encrypt(uboInfo.getIdNumber(), setting.getPlatformPublicKey()));
            }
        }

        /**
         * 结算银行账户
         */
        SubmitApplymentRequest.BankAccountInfo bankAccountInfo = request.getBankAccountInfo();
        if (bankAccountInfo != null) {
            bankAccountInfo.setAccountName(RSAUtils.encrypt(bankAccountInfo.getAccountName(), setting.getPlatformPublicKey()));
            bankAccountInfo.setAccountNumber(RSAUtils.encrypt(bankAccountInfo.getAccountNumber(), setting.getPlatformPublicKey()));
        }
        return jsonRequest(method, url, request, SubmitApplymentResponse.class);
    }

    /**
     * 通过业务申请编号查询申请状态
     *
     * @return GetApplymentResponse
     */
    public GetApplymentResponse getApplymentByBusinessCode(String businessCode) {
        String method = "GET";
        String url = String.format("/v3/applyment4sub/applyment/business_code/%s", businessCode);
        return jsonRequest(method, url, null, GetApplymentResponse.class);
    }

    /**
     * 通过申请单号查询申请状态
     *
     * @return GetApplymentResponse
     */
    public GetApplymentResponse getApplymentByApplymentId(String applymentId) {
        String method = "GET";
        String url = String.format("/v3/applyment4sub/applyment/applyment_id/%s", applymentId);
        return jsonRequest(method, url, null, GetApplymentResponse.class);
    }

    /**
     * 修改结算帐号API
     *
     * @param subMchid
     * @param request
     * @return
     */
    public ModifySettlementResponse modifySettlement(String subMchid, ModifySettlementRequest request) {
        String method = "POST";
        String url = String.format("/v3/apply4sub/sub_merchants/%s/modify-settlement", subMchid);
        return jsonRequest(method, url, request, ModifySettlementResponse.class);
    }

    /**
     * 查询结算账户API
     *
     * @param subMchid
     * @return
     */
    public GetSettlementResponse getSettlement(String subMchid) {
        String method = "GET";
        String url = String.format("/v3/apply4sub/sub_merchants/%s/settlement", subMchid);
        return jsonRequest(method, url, null, GetSettlementResponse.class);
    }
}
