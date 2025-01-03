package aria.license.CustomerManager.Controller;

import aria.license.CustomerManager.DTO.CustomerManagerDTO;
import aria.license.CustomerManager.Entity.CustomerManager;
import aria.license.CustomerManager.Service.CustomerManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-managers")
public class CustomerManagerController {
    private final CustomerManagerService service;

    public CustomerManagerController(CustomerManagerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerManagerDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerManagerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerManagerDTO> create(@RequestBody CustomerManagerDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerManagerDTO> update(@PathVariable Long id, @RequestBody CustomerManagerDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
