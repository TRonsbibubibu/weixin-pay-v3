package work.trons.library.weixin.beans.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixin.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/8
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadResponse extends BaseResponse {
    @JsonProperty("media_id")
    private String mediaId;
}
