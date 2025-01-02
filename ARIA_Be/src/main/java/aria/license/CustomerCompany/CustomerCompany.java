package aria.license.CustomerCompany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer_company")
public class CustomerCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "korean_name",nullable = false)
    private String koreanName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "additional_name")
    private String additionalName;

    private String location;

    private String website;

    private String description;

}
