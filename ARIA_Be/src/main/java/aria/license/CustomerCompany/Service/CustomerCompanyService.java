package aria.license.CustomerCompany.Service;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import aria.license.CustomerCompany.Repository.CustomerCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerCompanyService {

    private final CustomerCompanyRepository customerCompanyRepository;

    public CustomerCompanyService(CustomerCompanyRepository customerCompanyRepository) {
        this.customerCompanyRepository = customerCompanyRepository;
    }

    public List<CustomerCompany> findAll() {
        return customerCompanyRepository.findAll();
    }

    public Optional<CustomerCompany> findById(Long id) {
        return customerCompanyRepository.findById(id);
    }

    public CustomerCompany save(CustomerCompany customerCompany) {
        return customerCompanyRepository.save(customerCompany);
    }

    public void deleteById(Long id) {
        customerCompanyRepository.deleteById(id);
    }
}
