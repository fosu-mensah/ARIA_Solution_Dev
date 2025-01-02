package aria.license.User.Repository;


import aria.license.User.Entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, Integer> {
    // 특정 유저의 로그 검색
    List<UserLog> findByUserId(Integer userId);
}