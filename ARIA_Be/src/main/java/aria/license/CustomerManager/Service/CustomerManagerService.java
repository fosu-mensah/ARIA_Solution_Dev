package aria.license.CustomerManager.Service;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import aria.license.CustomerCompany.Repository.CustomerCompanyRepository;
import aria.license.CustomerManager.DTO.CustomerManagerDTO;
import aria.license.CustomerManager.Repository.CustomerManagerRepository;
import aria.license.CustomerManager.Entity.CustomerManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManagerService {
    private final CustomerManagerRepository managerRepository;
    private final CustomerCompanyRepository companyRepository;

    public CustomerManagerService(CustomerManagerRepository managerRepository, CustomerCompanyRepository companyRepository) {
        this.managerRepository = managerRepository;
        this.companyRepository = companyRepository;
    }

    public List<CustomerManagerDTO> findAll() {
        return managerRepository.findAll().stream()
                .map(CustomerManagerDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CustomerManagerDTO findById(Long id) {
        CustomerManager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerManager not found"));
        return CustomerManagerDTO.fromEntity(manager);
    }

    public CustomerManagerDTO save(CustomerManagerDTO dto) {
        CustomerCompany company = companyRepository.findById(dto.getCustomerCompanyId())
                .orElseThrow(() -> new RuntimeException("CustomerCompany not found"));

        CustomerManager manager = dto.toEntity();
        manager.setCustomerCompany(company);
        CustomerManager savedManager = managerRepository.save(manager);

        return CustomerManagerDTO.fromEntity(savedManager);
    }

    public CustomerManagerDTO update(Long id, CustomerManagerDTO dto) {
        CustomerManager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerManager not found"));

        manager.setName(dto.getName());
        manager.setPosition(dto.getPosition());
        manager.setRank(dto.getRank());
        manager.setDepartment(dto.getDepartment());
        manager.setOfficeContact(dto.getOfficeContact());
        manager.setMobileContact(dto.getMobileContact());
        manager.setFaxContact(dto.getFaxContact());
        manager.setDescription(dto.getDescription());

        if (dto.getCustomerCompanyId() != null) {
            CustomerCompany company = companyRepository.findById(dto.getCustomerCompanyId())
                    .orElseThrow(() -> new RuntimeException("CustomerCompany not found"));
            manager.setCustomerCompany(company);
        }

        return CustomerManagerDTO.fromEntity(managerRepository.save(manager));
    }

    public void delete(Long id) {
        managerRepository.deleteById(id);
    }
}