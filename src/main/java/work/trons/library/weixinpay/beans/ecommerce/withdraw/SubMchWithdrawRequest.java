package work.trons.library.weixinpay.beans.ecommerce.withdraw;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubMchWithdrawRequest {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("out_request_no")
    private String outRequestNo;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("bank_memo")
    private String bankMemo;
}
