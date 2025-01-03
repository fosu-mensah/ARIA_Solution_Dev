package aria.license.CustomerManager.DTO;

import aria.license.CustomerManager.Entity.CustomerManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerManagerDTO {
    private Long seq;
    private String name;
    private String position;
    private String rank;
    private String department;
    private String officeContact;
    private String mobileContact;
    private String faxContact;
    private String description;
    private Long customerCompanyId; // 연관된 고객사의 ID

    public static CustomerManagerDTO fromEntity(CustomerManager manager) {
        CustomerManagerDTO dto = new CustomerManagerDTO();
        dto.setSeq(manager.getSeq());
        dto.setName(manager.getName());
        dto.setPosition(manager.getPosition());
        dto.setRank(manager.getRank());
        dto.setDepartment(manager.getDepartment());
        dto.setOfficeContact(manager.getOfficeContact());
        dto.setMobileContact(manager.getMobileContact());
        dto.setFaxContact(manager.getFaxContact());
        dto.setDescription(manager.getDescription());
        dto.setCustomerCompanyId(manager.getCustomerCompany().getSeq());
        return dto;
    }

    public CustomerManager toEntity() {
        CustomerManager manager = new CustomerManager();
        manager.setName(this.name);
        manager.setPosition(this.position);
        manager.setRank(this.rank);
        manager.setDepartment(this.department);
        manager.setOfficeContact(this.officeContact);
        manager.setMobileContact(this.mobileContact);
        manager.setFaxContact(this.faxContact);
        manager.setDescription(this.description);
        return manager;
    }
}
