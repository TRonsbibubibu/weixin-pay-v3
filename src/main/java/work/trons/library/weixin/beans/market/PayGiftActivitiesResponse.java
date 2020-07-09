package work.trons.library.weixin.beans.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixin.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayGiftActivitiesResponse extends BaseResponse {
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("data")
    private List<Data> data;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data{

    }
}
