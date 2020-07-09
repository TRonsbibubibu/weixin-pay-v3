package work.trons.library.weixin.beans.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import work.trons.library.weixin.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplymentResponse extends BaseResponse {
    @JsonProperty("applyment_state")
    private String applymentState;
    @JsonProperty("applyment_state_desc")
    private String applymentStateDesc;
    @JsonProperty("sign_url")
    private String signUrl;
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("account_validation")
    private AccountValidation accountValidation;
    @JsonProperty("legal_validation_url")
    private String legalValidationUrl;
    @JsonProperty("out_request_no")
    private String outRequestNo;
    @JsonProperty("applyment_id")
    private long applymentId;
    @JsonProperty("audit_detail")
    private List<AuditDetail> auditDetail;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AccountValidation {
        @JsonProperty("account_name")
        private String accountName;
        @JsonProperty("account_no")
        private String accountNo;
        @JsonProperty("pay_amount")
        private int payAmount;
        @JsonProperty("destination_account_number")
        private String destinationAccountNumber;
        @JsonProperty("destination_account_name")
        private String destinationAccountName;
        @JsonProperty("destination_account_bank")
        private String destinationAccountBank;
        @JsonProperty("city")
        private String city;
        @JsonProperty("remark")
        private String remark;
        @JsonProperty("deadline")
        private String deadline;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AuditDetail {
        @JsonProperty("param_name")
        private String paramName;
        @JsonProperty("reject_reason")
        private String rejectReason;
    }
}
