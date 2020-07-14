package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.common.*;
import work.trons.library.weixinpay.core.PaySetting;

/**
 * @author liujiawei
 * @date 2020/7/8
 */
public class CommonApi extends BaseApi {

    private CommonApi(PaySetting setting) {
        super(setting);
    }

    public static CommonApi with(PaySetting setting) {
        return new CommonApi(setting);
    }

    public UploadResponse imageUpload(String filename, byte[] fileData) {
        String url = "/v3/merchant/media/upload";
        return this.fileRequest(url, filename, fileData, UploadResponse.class);
    }

    public UploadResponse videoUpload(String filename, byte[] fileData) {
        String url = "/v3/merchant/media/video_upload";
        return this.fileRequest(url, filename, fileData, UploadResponse.class);
    }

    public PlatformCertResponse platformCert() {
        String url = "/v3/certificates";
        return this.jsonRequest("GET", url, null, PlatformCertResponse.class);
    }

    /**
     * 获取商户开户意愿确认状态
     *
     * @param subMchid
     * @return
     */
    public SubjectApplymentStateResponse subjectApplymentState(String subMchid) {
        throw new UnsupportedOperationException();
    }

    /**
     * 查询申请单审核结果
     *
     * @param applymentId
     * @return
     */
    public SubjectApplymentResponse subjectApplymentByApplymentId(String applymentId) {
        throw new UnsupportedOperationException();
    }

    /**
     * 查询申请单审核结果
     *
     * @param businessCode
     * @return
     */
    public SubjectApplymentResponse subjectApplymentByBusinessCode(String businessCode) {
        throw new UnsupportedOperationException();
    }

    /**
     * 提交申请单
     *
     * @param request
     * @return
     */
    public SubmitSubjectApplymentResponse submitSubjectApplyment(SubmitSubjectApplymentRequest request) {
        throw new UnsupportedOperationException();
    }

    /**
     * 撤销申请单
     *
     * @param applymentId
     * @return
     */
    public CancelSubjectApplyment cancelSubjectApplymentByApplymentId(String applymentId) {
        throw new UnsupportedOperationException();
    }

    /**
     * 撤销申请单
     *
     * @param businessCode
     * @return
     */
    public CancelSubjectApplyment cancelSubjectApplymentByBusinessCode(String businessCode) {
        throw new UnsupportedOperationException();
    }
}
