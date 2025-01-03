package aria.license.CustomerManager.Repository;

import aria.license.CustomerManager.Entity.CustomerManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerManagerRepository extends JpaRepository<CustomerManager, Long> {
}
