package aria.license.User.Service;


import aria.license.User.Entity.User;
import aria.license.User.Entity.UserLog;
import aria.license.User.Repository.UserLogRepository;
import aria.license.User.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserLogRepository userLogRepository;

    public UserService(UserRepository userRepository, UserLogRepository userLogRepository) {
        this.userRepository = userRepository;
        this.userLogRepository = userLogRepository;
    }

    @Transactional
    public User register(User user) {
        // Check if username or email already exists
        Optional<User> existingUserByUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserByUsername.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserByEmail.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.setCreatedAt(LocalDateTime.now());

        System.out.println("Encrypted Password: " + encryptedPassword);

        // 사용자 저장
        return userRepository.save(user);
    }

    public void logAction(Integer userId, String action) {
        UserLog log = new UserLog();
        log.setUserId(userId);
        log.setLog(action);
        log.setCreatedAt(LocalDateTime.now());
        userLogRepository.save(log);
    }
}
