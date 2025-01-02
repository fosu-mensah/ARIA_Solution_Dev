package aria.license.Config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Key 생성
    private static final long EXPIRATION_TIME = 86400000; // 1일 (밀리초)

    // 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key) // 생성된 key 사용
                .compact();
    }

    // 토큰 검증
    public String validateToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject(); // 토큰에서 username(subject) 반환
        } catch (JwtException e) {
            throw new RuntimeException("Invalid or expired token", e);
        }
    }
}