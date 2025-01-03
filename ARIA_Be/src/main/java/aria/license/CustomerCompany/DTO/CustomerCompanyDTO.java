package aria.license.CustomerCompany.DTO;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCompanyDTO {
    private Long seq;
    private String koreanName;
    private String englishName;
    private String additionalName;
    private String location;
    private String website;
    private String description;

    public static CustomerCompanyDTO fromEntity(CustomerCompany company) {
        CustomerCompanyDTO dto = new CustomerCompanyDTO();
        dto.setSeq(company.getSeq());
        dto.setKoreanName(company.getKoreanName());
        dto.setEnglishName(company.getEnglishName());
        dto.setAdditionalName(company.getAdditionalName());
        dto.setLocation(company.getLocation());
        dto.setWebsite(company.getWebsite());
        dto.setDescription(company.getDescription());
        return dto;
    }

    public CustomerCompany toEntity() {
        CustomerCompany company = new CustomerCompany();
        company.setKoreanName(this.koreanName);
        company.setEnglishName(this.englishName);
        company.setAdditionalName(this.additionalName);
        company.setLocation(this.location);
        company.setWebsite(this.website);
        company.setDescription(this.description);
        return company;
    }
}
