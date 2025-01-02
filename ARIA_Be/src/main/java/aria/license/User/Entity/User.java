package aria.license.User.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "유저ID")
    private Integer userid;

    @Column(name = "Token")
    private String token;

    @Column(name = "유저이름")
    private String username;

    @Column(name = "패스워드")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "생성시간")
    private LocalDateTime createdAt; // 필드 추가
}
