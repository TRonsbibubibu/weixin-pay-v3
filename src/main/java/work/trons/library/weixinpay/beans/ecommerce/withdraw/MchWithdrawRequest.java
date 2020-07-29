package work.trons.library.weixinpay.beans.ecommerce.withdraw;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MchWithdrawRequest {
    @JsonProperty("out_request_no")
    private String outRequestNo;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("bank_memo")
    private String bankMemo;
    @JsonProperty("account_type")
    private String accountType;
}
