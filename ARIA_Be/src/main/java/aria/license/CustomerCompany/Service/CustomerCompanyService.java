package aria.license.CustomerCompany.Service;

import aria.license.CustomerCompany.DTO.CustomerCompanyDTO;
import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import aria.license.CustomerCompany.Repository.CustomerCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerCompanyService {
    private final CustomerCompanyRepository companyRepository;

    public CustomerCompanyService(CustomerCompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CustomerCompanyDTO> findAll() {
        return companyRepository.findAll().stream()
                .map(CustomerCompanyDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CustomerCompanyDTO findById(Long id) {
        CustomerCompany company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerCompany not found"));
        return CustomerCompanyDTO.fromEntity(company);
    }

    public CustomerCompanyDTO save(CustomerCompanyDTO dto) {
        CustomerCompany company = dto.toEntity();
        CustomerCompany savedCompany = companyRepository.save(company);
        return CustomerCompanyDTO.fromEntity(savedCompany);
    }

    public CustomerCompanyDTO update(Long id, CustomerCompanyDTO dto) {
        CustomerCompany company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerCompany not found"));

        company.setKoreanName(dto.getKoreanName());
        company.setEnglishName(dto.getEnglishName());
        company.setAdditionalName(dto.getAdditionalName());
        company.setLocation(dto.getLocation());
        company.setWebsite(dto.getWebsite());
        company.setDescription(dto.getDescription());

        CustomerCompany updatedCompany = companyRepository.save(company);
        return CustomerCompanyDTO.fromEntity(updatedCompany);
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
