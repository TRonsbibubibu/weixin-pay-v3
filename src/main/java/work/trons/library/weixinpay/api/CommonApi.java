package work.trons.library.weixinpay.api;

import work.trons.library.weixinpay.beans.common.PlatformCertResponse;
import work.trons.library.weixinpay.beans.common.UploadResponse;
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
}
