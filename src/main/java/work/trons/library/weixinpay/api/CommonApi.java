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

    public SubjectApplymentStateResponse subjectApplymentState(String subMchid) {
        throw new UnsupportedOperationException();
    }

    public SubjectApplymentResponse subjectApplyment(Long applymentId) {
        throw new UnsupportedOperationException();
    }

    public SubjectApplymentResponse subjectApplyment(String businessCode) {
        throw new UnsupportedOperationException();
    }

    public SubmitSubjectApplymentResponse submitSubjectApplyment(SubmitSubjectApplymentRequest request) {
        throw new UnsupportedOperationException();
    }

    public CancelSubjectApplyment cancelSubjectApplyment(Long applymentId) {
        throw new UnsupportedOperationException();
    }

    public CancelSubjectApplyment cancelSubjectApplyment(String businessCode) {
        throw new UnsupportedOperationException();
    }
}
