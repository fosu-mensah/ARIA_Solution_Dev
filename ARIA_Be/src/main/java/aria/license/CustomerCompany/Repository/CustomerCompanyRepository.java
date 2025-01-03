package aria.license.CustomerCompany.Repository;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany, Long> {
}