package aria.license.User.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "User_Log")
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "로그ID")
    private Integer logId;

    @Column(name = "유저ID", nullable = false)
    private Integer userId;

    @Column(name = "로그")
    private String log;

    @Column(name = "로그생성일시")
    private LocalDateTime createdAt;
}
