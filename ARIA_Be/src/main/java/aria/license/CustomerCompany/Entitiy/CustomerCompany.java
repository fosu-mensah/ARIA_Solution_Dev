package aria.license.CustomerCompany.Entitiy;

import aria.license.CustomerManager.Entity.CustomerManager;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer_company")
public class CustomerCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "korean_name", nullable = false)
    private String koreanName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "additional_name")
    private String additionalName;

    private String location;
    private String website;
    private String description;

    @OneToMany(mappedBy = "customerCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerManager> customerManagers = new ArrayList<>();
}
