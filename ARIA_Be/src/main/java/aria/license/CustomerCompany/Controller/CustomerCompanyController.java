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
    private final CustomerCompanyService service;

    public CustomerCompanyController(CustomerCompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerCompanyDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerCompanyDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerCompanyDTO> create(@RequestBody CustomerCompanyDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerCompanyDTO> update(@PathVariable Long id, @RequestBody CustomerCompanyDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
