package aria.license.User.Repository;

import aria.license.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 사용자 이름으로 검색
    Optional<User> findByUsername(String username);

    // 이메일로 검색
    Optional<User> findByEmail(String email);
}