package work.trons.library.weixinpay.api;

import lombok.SneakyThrows;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import work.trons.library.weixinpay.beans.BaseResponse;
import work.trons.library.weixinpay.core.PaySetting;
import work.trons.library.weixinpay.core.http.HttpClientFactory;
import work.trons.library.weixinpay.utils.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
public abstract class BaseApi {

    private static final CloseableHttpClient httpClient = HttpClientFactory.build();
    private static final String MCH_URI = "https://api.mch.weixin.qq.com";
    protected final PaySetting setting;

    protected BaseApi(PaySetting setting) {
        this.setting = setting;
    }

    protected static String queryString(Map<String, Object> query) {
        return query.keySet()
                .stream()
                .map(k -> {
                    return String.format("%s=%s", k, query.get(k));
                })
                .collect(Collectors.joining("&"));
    }

    @SneakyThrows
    private String sign(String method, String url, Long requestTime, String randomStr, String body) {
        String builder = method + '\n' +
                url + '\n' +
                requestTime + '\n' +
                randomStr + '\n' +
                body + '\n';
        return RSAUtils.sign(setting.getMchPrivateKey(), builder, setting.getSignatureAlgorithm());
    }

    @SneakyThrows
    protected <T extends BaseResponse> T jsonRequest(String method, String url, Object body, Class<T> clazz) {
        Long requestTime = System.currentTimeMillis() / 1000;
        String randomStr = String.valueOf(Math.random());
        String bodyStr = body == null ? StringUtils.EMPTY : JsonUtils.toJson(body);
        String sign = sign(method, url, requestTime, randomStr, bodyStr);
        String signInfo = "mchid=\"" + setting.getMchId() + "\","
                + "nonce_str=\"" + randomStr + "\","
                + "timestamp=\"" + requestTime + "\","
                + "serial_no=\"" + setting.getMchSerialNo() + "\","
                + "signature=\"" + sign + "\"";

        RequestBuilder requestBuilder = RequestBuilder
                .create(method)
                .setUri(MCH_URI + url)
                .addHeader("Wechatpay-Serial", setting.getPlatformSerialNo())
                .addHeader("Authorization", String.format("%s %s", "WECHATPAY2-SHA256-RSA2048", signInfo))
                .addHeader("Accept", "application/json");
        if (!"GET".equals(method)) {
            requestBuilder
                    .setEntity(new StringEntity(bodyStr, ContentType.APPLICATION_JSON));
        }
        CloseableHttpResponse response = httpClient.execute(requestBuilder.build());
        String data = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        return JsonUtils.toObject(data, clazz);
    }

    @SneakyThrows
    protected <T extends BaseResponse> T fileRequest(String url, String filename, byte[] fileData, Class<T> clazz) {
        String metaStr = JsonUtils.toJson(MapUtils.immutable(
                "filename", filename,
                "sha256", EncryptUtils.sha256(fileData)
        ));
        Long requestTime = System.currentTimeMillis() / 1000;
        String randomStr = String.valueOf(Math.random());
        String sign = sign("POST", url, requestTime, randomStr, metaStr);
        String signInfo = "mchid=\"" + setting.getMchId() + "\","
                + "nonce_str=\"" + randomStr + "\","
                + "timestamp=\"" + requestTime + "\","
                + "serial_no=\"" + setting.getMchSerialNo() + "\","
                + "signature=\"" + sign + "\"";

        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create()
                .addBinaryBody("file", fileData, parseContentTypeFromFilename(filename), filename)
                .addTextBody("meta", metaStr, ContentType.APPLICATION_JSON);
        RequestBuilder requestBuilder = RequestBuilder
                .post(MCH_URI + url)
                .addHeader("Wechatpay-Serial", setting.getPlatformSerialNo())
                .addHeader("Authorization", String.format("%s %s", "WECHATPAY2-SHA256-RSA2048", signInfo))
                .addHeader("Accept", "application/json")
                .setEntity(entityBuilder.build());
        CloseableHttpResponse response = httpClient.execute(requestBuilder.build());
        String data = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        return JsonUtils.toObject(data, clazz);
    }

    private ContentType parseContentTypeFromFilename(String filename) {
        String lowerCase = filename.toLowerCase();
        if (lowerCase.endsWith(".png")) {
            return ContentType.IMAGE_PNG;
        } else if (lowerCase.endsWith(".jpg")) {
            return ContentType.IMAGE_JPEG;
        } else if (lowerCase.endsWith(".avi")) {
            return ContentType.create("video/avi");
        } else if (lowerCase.endsWith(".wmv")) {
            return ContentType.create("video/x-ms-wmv");
        } else if (lowerCase.endsWith(".mpeg")) {
            return ContentType.create("video/mpg");
        } else if (lowerCase.endsWith(".mp4")) {
            return ContentType.create("video/mp4");
        } else if (lowerCase.endsWith(".mov")) {
            return ContentType.create("video/quicktime");
        } else if (lowerCase.endsWith(".mkv")) {
            return ContentType.create("video/x-matroska");
        } else if (lowerCase.endsWith(".flv")) {
            return ContentType.create("video/x-flv");
        } else if (lowerCase.endsWith(".f4v")) {
            return ContentType.create("video/x-f4v");
        } else if (lowerCase.endsWith(".m4v")) {
            return ContentType.create("video/mp4");
        } else if (lowerCase.endsWith(".rmvb")) {
            return ContentType.create("application/vnd.rn-realmedia-vbr");
        } else {
            throw new IllegalArgumentException(String.format("文件名[%s]后缀不合法", filename));
        }
    }
}
