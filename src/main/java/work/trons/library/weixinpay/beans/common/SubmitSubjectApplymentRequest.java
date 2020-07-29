package work.trons.library.weixinpay.beans.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubmitSubjectApplymentRequest {
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("business_code")
    private String businessCode;
    @JsonProperty("contact_info")
    private ContactInfo contactInfo;
    @JsonProperty("subject_info")
    private SubjectInfo subjectInfo;
    @JsonProperty("identification_info")
    private IdentificationInfo identificationInfo;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ContactInfo {
        @JsonProperty("name")
        private String name;
        @JsonProperty("mobile")
        private String mobile;
        @JsonProperty("id_card_number")
        private String idCardNumber;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SubjectInfo {
        @JsonProperty("subject_type")
        private String subjectType;
        @JsonProperty("business_licence_info")
        private BusinessLicenceInfo businessLicenceInfo;
        @JsonProperty("certificate_info")
        private CertificateInfo certificateInfo;
        @JsonProperty("company_prove_copy")
        private String companyProveCopy;
        @JsonProperty("assist_prove_info")
        private AssistProveInfo assistProveInfo;
        @JsonProperty("special_operation_info")
        private List<SpecialOperationInfo> specialOperationInfo;


        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class BusinessLicenceInfo {
            @JsonProperty("licence_number")
            private String licenceNumber;
            @JsonProperty("licence_copy")
            private String licenceCopy;
            @JsonProperty("merchant_name")
            private String merchantName;
            @JsonProperty("legal_person")
            private String legalPerson;
            @JsonProperty("company_address")
            private String companyAddress;
            @JsonProperty("licence_valid_date")
            private String licenceValidDate;
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class CertificateInfo {
            @JsonProperty("cert_type")
            private String certType;
            @JsonProperty("cert_number")
            private String certNumber;
            @JsonProperty("cert_copy")
            private String certCopy;
            @JsonProperty("merchant_name")
            private String merchantName;
            @JsonProperty("legal_person")
            private String legalPerson;
            @JsonProperty("company_address")
            private String companyAddress;
            @JsonProperty("cert_valid_date")
            private String certValidDate;
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class AssistProveInfo {
            @JsonProperty("micro_biz_type")
            private String microBizType;
            @JsonProperty("store_name")
            private String storeName;
            @JsonProperty("store_address_code")
            private String storeAddressCode;
            @JsonProperty("store_address")
            private String storeAddress;
            @JsonProperty("store_header_copy")
            private String storeHeaderCopy;
            @JsonProperty("store_indoor_copy")
            private String storeIndoorCopy;
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class SpecialOperationInfo {
            @JsonProperty("category_id")
            private String categoryId;
            @JsonProperty("store_indoor_copy")
            private String storeIndoorCopy;
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class IdentificationInfo {
        @JsonProperty("identification_type")
        private String identificationType;
        @JsonProperty("identification_name")
        private String identificationName;
        @JsonProperty("identification_number")
        private String identificationNumber;
        @JsonProperty("identification_valid_date")
        private String identificationValidDate;
        @JsonProperty("identification_front_copy")
        private String identificationFrontCopy;
        @JsonProperty("identification_back_copy")
        private String identificationBackCopy;
    }
}
