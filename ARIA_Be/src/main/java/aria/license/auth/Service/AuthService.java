package aria.license.auth.Service;

import aria.license.Config.JwtUtil;
import aria.license.User.Entity.User;
import aria.license.User.Entity.UserLog;
import aria.license.User.Repository.UserLogRepository;
import aria.license.User.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserLogRepository userLogRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, UserLogRepository userLogRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userLogRepository = userLogRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(username);

        // Save the token to the user if needed
        user.setToken(token);
        userRepository.save(user);

        // Log the login action
        saveLoginLog(user);

        return token;
    }

    public void logout(String token) {
        // 토큰 검증 및 username 추출
        String username = jwtUtil.validateToken(token);

        // 유저 조회
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 토큰 필드 초기화
        user.setToken(null);
        userRepository.save(user);

        // 로그아웃 로그 저장
        saveLogoutLog(user);
    }

    private void saveLoginLog(User user) {
        UserLog log = new UserLog();
        log.setUserId(user.getUserid());
        log.setLog("User logged in");
        log.setCreatedAt(LocalDateTime.now());
        userLogRepository.save(log);
    }

    private void saveLogoutLog(User user) {
        if (user == null || user.getUserid() == null) {
            throw new RuntimeException("Invalid user or userId is null");
        }

        UserLog log = new UserLog();
        log.setUserId(user.getUserid()); // 유저 ID 설정
        log.setLog("User logged out");   // 로그 내용
        log.setCreatedAt(LocalDateTime.now()); // 로그 생성 시간
        userLogRepository.save(log);
    }
}