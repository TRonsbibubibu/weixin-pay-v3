package work.trons.library.weixinpay.beans.ecommerce.applyment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEcoSettlementResponse extends BaseResponse {
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("account_bank")
    private String accountBank;
    @JsonProperty("bank_name")
    private String bankName;
    @JsonProperty("bank_branch_id")
    private String bankBranchId;
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("verify_result")
    private String verifyResult;
}
