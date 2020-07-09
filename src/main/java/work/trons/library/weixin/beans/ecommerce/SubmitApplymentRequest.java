package work.trons.library.weixin.beans.ecommerce;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author liujiawei
 * @date 2020/6/20
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubmitApplymentRequest {
    @JsonProperty("out_request_no")
    private String outRequestNo;
    @JsonProperty("organization_type")
    private String organizationType;
    @JsonProperty("business_license_info")
    private BusinessLicenseInfo businessLicenseInfo;
    @JsonProperty("organization_cert_info")
    private OrganizationCertInfo organizationCerInfo;
    @JsonProperty("id_doc_type")
    private String idDocType;
    @JsonProperty("id_card_info")
    private IdCardInfo idCardInfo;
    @JsonProperty("need_account_info")
    private boolean needAccountInfo;
    @JsonProperty("account_info")
    private AccountInfo accountInfo;
    @JsonProperty("contact_info")
    private ContactInfo contactInfo;
    @JsonProperty("sales_scene_info")
    private SalesSceneInfo salesSceneInfo;
    @JsonProperty("sales_scene_info")
    private String merchantShortname;
    @JsonProperty("qualifications")
    private List<String> qualifications;
    @JsonProperty("business_addition_pics")
    private List<String> businessAdditionPics;
    @JsonProperty("business_addition_desc")
    private String businessAdditionDesc;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BusinessLicenseInfo {
        @JsonProperty("business_license_copy")
        private String businessLicenseCopy;
        @JsonProperty("business_license_number")
        private String businessLicenseNumber;
        @JsonProperty("merchant_name")
        private String merchantName;
        @JsonProperty("legal_person")
        private String legalPerson;
        @JsonProperty("company_address")
        private String companyAddress;
        @JsonProperty("business_time")
        private String businessTime;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class OrganizationCertInfo {
        @JsonProperty("organization_copy")
        private String organizationCopy;
        @JsonProperty("organization_number")
        private String organizationNumber;
        @JsonProperty("organization_time")
        private String organizationTime;
    }

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
        @JsonProperty("id_card_valid_time")
        private String idCardValidTime;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AccountInfo {
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
    public static class ContactInfo {
        @JsonProperty("contact_type")
        private String contactType;
        @JsonProperty("contact_name")
        private String contactName;
        @JsonProperty("contact_id_card_number")
        private String contactIdCardNumber;
        @JsonProperty("mobile_phone")
        private String mobilePhone;
        @JsonProperty("contact_email")
        private String contactEmail;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SalesSceneInfo {
        @JsonProperty("store_name")
        private String storeName;
        @JsonProperty("store_url")
        private String storeUrl;
        @JsonProperty("store_qr_code")
        private String storeQrCode;
    }
}
