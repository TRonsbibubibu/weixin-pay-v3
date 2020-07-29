package work.trons.library.weixinpay.beans.complaInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import work.trons.library.weixinpay.beans.BaseResponse;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/29
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryComplaintResponse extends BaseResponse {
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("data")
    private List<Data> data;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("complaInteger_time")
        private String complaIntegerTime;
        @JsonProperty("amount")
        private Integer amount;
        @JsonProperty("payer_phone")
        private String payerPhone;
        @JsonProperty("complaInteger_detail")
        private String complaIntegerDetail;
        @JsonProperty("complaInteger_state")
        private String complaIntegerState;
        @JsonProperty("transaction_id")
        private String transactionId;
        @JsonProperty("frozen_end_time")
        private String frozenEndTime;
        @JsonProperty("sub_mchid")
        private String subMchid;
    }
}
