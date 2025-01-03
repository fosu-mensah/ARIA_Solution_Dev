package aria.license.CustomerManager.Entity;

import aria.license.CustomerCompany.Entitiy.CustomerCompany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "customer_manager")
public class CustomerManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "customer_company_seq", nullable = false)
    private CustomerCompany customerCompany;

    @Column(nullable = false)
    private String name;

    private String position;
    private String rank;
    private String department;
    private String officeContact;
    private String mobileContact;
    private String faxContact;
    private String description;
}
