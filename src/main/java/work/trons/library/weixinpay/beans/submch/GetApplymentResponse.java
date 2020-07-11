package work.trons.library.weixinpay.beans.submch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/11
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetApplymentResponse extends BaseResponse {
    @JsonProperty("business_code")
    private String businessCode;
    @JsonProperty("applyment_id")
    private Long applymentId;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("sign_url")
    private String signUrl;
    @JsonProperty("applyment_state")
    private String applymentState;
    @JsonProperty("applyment_state_msg")
    private String applymentStateMsg;
    @JsonProperty("audit_detail")
    private List<AuditDetail> auditDetail;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AuditDetail {
        @JsonProperty("field")
        private String field;
        @JsonProperty("field_name")
        private String fieldName;
        @JsonProperty("reject_reason")
        private String rejectReason;
    }
}

