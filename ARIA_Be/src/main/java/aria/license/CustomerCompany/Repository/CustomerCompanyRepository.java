package aria.license.CustomerCompany.Repository;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany, Long> {
}
