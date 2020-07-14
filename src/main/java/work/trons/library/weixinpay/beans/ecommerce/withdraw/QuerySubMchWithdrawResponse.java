package work.trons.library.weixinpay.beans.ecommerce.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

/**
 * @author liujiawei
 * @date 2020/7/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuerySubMchWithdrawResponse extends BaseResponse {
    @JsonProperty("sub_mchid")
    private String subMchid;
    @JsonProperty("sp_mchid")
    private String spMchid;
    @JsonProperty("status")
    private String status;
    @JsonProperty("withdraw_id")
    private String withdrawId;
    @JsonProperty("out_request_no")
    private String outRequestNo;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("bank_memo")
    private String bankMemo;
}
