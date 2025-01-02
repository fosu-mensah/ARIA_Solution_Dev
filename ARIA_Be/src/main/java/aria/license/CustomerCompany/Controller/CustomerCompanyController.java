package aria.license.CustomerCompany.Controller;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import aria.license.CustomerCompany.Service.CustomerCompanyService;
import aria.license.CustomerCompany.DTO.CustomerCompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer-company")
public class CustomerCompanyController {

    private final CustomerCompanyService customerCompanyService;

    public CustomerCompanyController(CustomerCompanyService customerCompanyService) {
        this.customerCompanyService = customerCompanyService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerCompany>> getAllCustomerCompany() {
        List<CustomerCompany> customerCompanies = customerCompanyService.findAll();
        return ResponseEntity.ok(customerCompanies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerCompany> getCustomerCompanyById(@PathVariable Long id) {
        Optional<CustomerCompany> customerCompany = customerCompanyService.findById(id);
        return customerCompany.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerCompany> createCustomerCompany(@RequestBody CustomerCompanyDTO customerCompanyDTO) {
        // DTO -> Entity 변환
        CustomerCompany customerCompany = new CustomerCompany();
        customerCompany.setKoreanName(customerCompanyDTO.getKoreanName());
        customerCompany.setEnglishName(customerCompanyDTO.getEnglishName());
        customerCompany.setAdditionalName(customerCompanyDTO.getAdditionalName());
        customerCompany.setLocation(customerCompanyDTO.getLocation());
        customerCompany.setWebsite(customerCompanyDTO.getWebsite());
        customerCompany.setDescription(customerCompanyDTO.getDescription());

        CustomerCompany savedCustomerCompany = customerCompanyService.save(customerCompany);
        return ResponseEntity.ok(savedCustomerCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerCompany> updateCustomerCompany(
            @PathVariable Long id, @RequestBody CustomerCompanyDTO customerCompanyDTO) {
        Optional<CustomerCompany> existingCustomerCompany = customerCompanyService.findById(id);
        if (existingCustomerCompany.isPresent()) {
            CustomerCompany customerCompany = existingCustomerCompany.get();
            customerCompany.setKoreanName(customerCompanyDTO.getKoreanName());
            customerCompany.setEnglishName(customerCompanyDTO.getEnglishName());
            customerCompany.setAdditionalName(customerCompanyDTO.getAdditionalName());
            customerCompany.setLocation(customerCompanyDTO.getLocation());
            customerCompany.setWebsite(customerCompanyDTO.getWebsite());
            customerCompany.setDescription(customerCompanyDTO.getDescription());

            CustomerCompany updatedCustomerCompany = customerCompanyService.save(customerCompany);
            return ResponseEntity.ok(updatedCustomerCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerCompany(@PathVariable Long id) {
        customerCompanyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
