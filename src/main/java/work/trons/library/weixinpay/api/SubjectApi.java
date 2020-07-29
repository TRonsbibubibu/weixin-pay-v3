package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.common.*;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.utils.RSAUtils;

/**
 * 商户开户意愿确认
 *
 * @author liujiawei
 * @date 2020/7/29
 */
public class SubjectApi extends BaseApi {
    private SubjectApi(PaySetting setting) {
        super(setting);
    }

    public static SubjectApi with(PaySetting paySetting) {
        return new SubjectApi(paySetting);
    }

    /**
     * 提交申请单
     *
     * @param request
     * @return
     */
    public SubmitSubjectApplymentResponse submitSubjectApplyment(SubmitSubjectApplymentRequest request) {
        String method = "POST";
        String url = "/v3/apply4subject/applyment";

        if (request.getContactInfo() != null) {
            SubmitSubjectApplymentRequest.ContactInfo contactInfo = request.getContactInfo();
            contactInfo.setName(RSAUtils.encrypt(contactInfo.getName(), setting.getPlatformPublicKey()));
            contactInfo.setMobile(RSAUtils.encrypt(contactInfo.getMobile(), setting.getPlatformPublicKey()));
            contactInfo.setIdCardNumber(RSAUtils.encrypt(contactInfo.getIdCardNumber(), setting.getPlatformPublicKey()));
        }

        if (request.getIdentificationInfo() != null) {
            SubmitSubjectApplymentRequest.IdentificationInfo identificationInfo = request.getIdentificationInfo();
            identificationInfo.setIdentificationName(RSAUtils.encrypt(identificationInfo.getIdentificationName(), setting.getPlatformPublicKey()));
            identificationInfo.setIdentificationNumber(RSAUtils.encrypt(identificationInfo.getIdentificationNumber(), setting.getPlatformPublicKey()));
        }
        return jsonRequest(method, url, request, SubmitSubjectApplymentResponse.class);
    }

    /**
     * 撤销申请单
     *
     * @param applymentId
     * @return
     */
    public CancelSubjectApplyment cancelSubjectApplymentByApplymentId(String applymentId) {
        String method = "POST";
        String url = String.format("/v3/apply4subject/applyment/%s/cancel", applymentId);
        return jsonRequest(method, url, null, CancelSubjectApplyment.class);
    }

    /**
     * 撤销申请单
     *
     * @param businessCode
     * @return
     */
    public CancelSubjectApplyment cancelSubjectApplymentByBusinessCode(String businessCode) {
        String method = "POST";
        String url = String.format("/v3/apply4subject/applyment/%s/cancel", businessCode);
        return jsonRequest(method, url, null, CancelSubjectApplyment.class);
    }

    /**
     * 查询申请单审核结果
     *
     * @param applymentId
     * @return
     */
    public SubjectApplymentResponse subjectApplymentByApplymentId(String applymentId) {
        String method = "GET";
        String url = String.format("/v3/apply4subject/applyment?applyment_id=%s", applymentId);
        return jsonRequest(method, url, null, SubjectApplymentResponse.class);
    }

    /**
     * 查询申请单审核结果
     *
     * @param businessCode
     * @return
     */
    public SubjectApplymentResponse subjectApplymentByBusinessCode(String businessCode) {
        String method = "GET";
        String url = String.format("/v3/apply4subject/applyment?business_code=%s", businessCode);
        return jsonRequest(method, url, null, SubjectApplymentResponse.class);
    }

    /**
     * 获取商户开户意愿确认状态
     *
     * @param subMchid
     * @return
     */
    public SubjectApplymentStateResponse subjectApplymentState(String subMchid) {
        String method = "GET";
        String url = String.format("/v3/apply4subject/applyment/merchants/%s/state", subMchid);
        return jsonRequest(method, url, null, SubjectApplymentStateResponse.class);
    }
}
