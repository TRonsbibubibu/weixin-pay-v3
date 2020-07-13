package work.trons.library.weixinpay.beans.submch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/7/10
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubmitApplymentRequest {
    @JsonProperty("business_code")
    private String businessCode;
    @JsonProperty("contact_info")
    private ContactInfo contactInfo;
    @JsonProperty("subject_info")
    private SubjectInfo subjectInfo;
    @JsonProperty("business_info")
    private BusinessInfo businessInfo;
    @JsonProperty("settlement_info")
    private SettlementInfo settlementInfo;
    @JsonProperty("bank_account_info")
    private BankAccountInfo bankAccountInfo;
    @JsonProperty("addition_info")
    private AdditionInfo additionInfo;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ContactInfo {
        @JsonProperty("contact_name")
        private String contactName;
        @JsonProperty("contact_id_number")
        private String contactIdNumber;
        @JsonProperty("openid")
        private String openid;
        @JsonProperty("mobile_phone")
        private String mobilePhone;
        @JsonProperty("contact_email")
        private String contactEmail;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SubjectInfo {
        @JsonProperty("subject_type")
        private String subjectType;
        @JsonProperty("business_license_info")
        private BusinessLicenseInfo businessLicenseInfo;
        @JsonProperty("certificate_info")
        private CertificateInfo certificateInfo;
        @JsonProperty("organization_info")
        private OrganizationInfo organizationInfo;
        @JsonProperty("certificate_letter_copy")
        private String certificateLetterCopy;
        @JsonProperty("identity_info")
        private IdentityInfo identityInfo;
        @JsonProperty("ubo_info")
        private UboInfo uboInfo;

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class BusinessLicenseInfo {
            @JsonProperty("license_copy")
            private String licenseCopy;
            @JsonProperty("license_number")
            private String licenseNumber;
            @JsonProperty("merchant_name")
            private String merchantName;
            @JsonProperty("legal_person")
            private String legalPerson;
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class CertificateInfo {
            @JsonProperty("cert_copy")
            private String certCopy;
            @JsonProperty("cert_type")
            private String certType;
            @JsonProperty("cert_number")
            private String certNumber;
            @JsonProperty("merchant_name")
            private String merchantName;
            @JsonProperty("company_address")
            private String companyAddress;
            @JsonProperty("legal_person")
            private String legalPerson;
            @JsonProperty("period_begin")
            private String periodBegin;
            @JsonProperty("period_end")
            private String periodEnd;
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class OrganizationInfo {
            @JsonProperty("organization_copy")
            private String organizationCopy;
            @JsonProperty("organization_code")
            private String organizationCode;
            @JsonProperty("org_period_begin")
            private String orgPeriodBegin;
            @JsonProperty("org_period_end")
            private String orgPeriodEnd;

        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class IdentityInfo {
            @JsonProperty("id_doc_type")
            private String idDocType;
            @JsonProperty("id_card_info")
            private IdCardInfo idCardInfo;
            @JsonProperty("id_doc_info")
            private IdDocInfo idDocInfo;
            @JsonProperty("owner")
            private Boolean owner;

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class IdCardInfo {
                @JsonProperty("id_card_copy")
                private String idCardCopy;
                @JsonProperty("id_card_national")
                private String idCardNational;
                @JsonProperty("id_card_name")
                private String idCardName;
                @JsonProperty("id_card_number")
                private String idCardNumber;
                @JsonProperty("card_period_begin")
                private String cardPeriodBegin;
                @JsonProperty("card_period_end")
                private String cardPeriodEnd;

            }

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class IdDocInfo {
                @JsonProperty("id_doc_copy")
                private String idDocCopy;
                @JsonProperty("id_doc_name")
                private String idDocName;
                @JsonProperty("id_doc_number")
                private String idDocNumber;
                @JsonProperty("doc_period_begin")
                private String docPeriodBegin;
                @JsonProperty("doc_period_end")
                private String docPeriodEnd;
            }
        }

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class UboInfo {
            @JsonProperty("id_type")
            private String idType;
            @JsonProperty("id_card_copy")
            private String idCardCopy;
            @JsonProperty("id_card_national")
            private String idCardNational;
            @JsonProperty("id_doc_copy")
            private String idDocCopy;
            @JsonProperty("name")
            private String name;
            @JsonProperty("id_number")
            private String idNumber;
            @JsonProperty("id_period_begin")
            private String idPeriodBegin;
            @JsonProperty("id_period_end")
            private String idPeriodEnd;
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BusinessInfo {
        @JsonProperty("merchant_shortname")
        private String merchantShortname;
        @JsonProperty("service_phone")
        private String servicePhone;
        @JsonProperty("sales_info")
        private SalesInfo salesInfo;

        @Data
        @Builder
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class SalesInfo {
            @JsonProperty("biz_store_info")
            private BizStoreInfo bizStoreInfo;
            @JsonProperty("mp_info")
            private MpInfo mpInfo;
            @JsonProperty("mini_program_info")
            private MiniProgramInfo miniProgramInfo;
            @JsonProperty("app_info")
            private AppInfo appInfo;
            @JsonProperty("web_info")
            private WebInfo webInfo;
            @JsonProperty("wework_info")
            private WeworkInfo weworkInfo;
            @JsonProperty("sales_scenes_type")
            private List<String> salesScenesType;

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class BizStoreInfo {
                @JsonProperty("biz_store_name")
                private String bizStoreName;
                @JsonProperty("biz_address_code")
                private String bizAddressCode;
                @JsonProperty("biz_store_address")
                private String bizStoreAddress;
                @JsonProperty("biz_sub_appid")
                private String bizSubAppid;
                @JsonProperty("store_entrance_pic")
                private List<String> storeEntrancePic;
                @JsonProperty("indoor_pic")
                private List<String> indoorPic;
            }

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class MpInfo {
                @JsonProperty("mp_appid")
                private String mpAppid;
                @JsonProperty("mp_sub_appid")
                private String mpSubAppid;
                @JsonProperty("mp_pics")
                private List<String> mpPics;

            }

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class MiniProgramInfo {
                @JsonProperty("mini_program_appid")
                private String miniProgramAppid;
                @JsonProperty("mini_program_sub_appid")
                private String miniProgramSubAppid;
                @JsonProperty("mini_program_pics")
                private List<String> miniProgramPics;

            }

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class AppInfo {
                @JsonProperty("app_appid")
                private String appAppid;
                @JsonProperty("app_sub_appid")
                private String appSubAppid;
                @JsonProperty("app_pics")
                private List<String> appPics;

            }

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class WebInfo {
                @JsonProperty("domain")
                private String domain;
                @JsonProperty("web_authorisation")
                private String webAuthorisation;
                @JsonProperty("web_appid")
                private String webAppid;

            }

            @Data
            @Builder
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class WeworkInfo {
                @JsonProperty("corp_id")
                private String corpId;
                @JsonProperty("sub_corp_id")
                private String subCorpId;
                @JsonProperty("wework_pics")
                private List<String> weworkPics;
            }
        }
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SettlementInfo {
        @JsonProperty("settlement_id")
        private String settlementId;
        @JsonProperty("qualification_type")
        private String qualificationType;
        @JsonProperty("activities_id")
        private String activitiesId;
        @JsonProperty("activities_rate")
        private String activitiesRate;
        @JsonProperty("qualifications")
        private List<String> qualifications;
        @JsonProperty("activities_additions")
        private List<String> activitiesAdditions;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BankAccountInfo {
        @JsonProperty("bank_account_type")
        private String bankAccountType;
        @JsonProperty("account_name")
        private String accountName;
        @JsonProperty("account_bank")
        private String accountBank;
        @JsonProperty("bank_address_code")
        private String bankAddressCode;
        @JsonProperty("bank_branch_id")
        private String bankBranchId;
        @JsonProperty("bank_name")
        private String bankName;
        @JsonProperty("account_number")
        private String accountNumber;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AdditionInfo {
        @JsonProperty("legal_person_commitment")
        private String legalPersonCommitment;
        @JsonProperty("legal_person_video")
        private String legalPersonVideo;
        @JsonProperty("business_addition_msg")
        private String businessAdditionMsg;
        @JsonProperty("business_addition_pics")
        private List<String> businessAdditionPics;
    }
}