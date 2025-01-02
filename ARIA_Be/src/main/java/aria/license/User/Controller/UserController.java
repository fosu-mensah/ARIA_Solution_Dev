package aria.license.User.Controller;

import aria.license.User.Entity.User;
import aria.license.User.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User registeredUser = userService.register(user);
            return ResponseEntity.ok(registeredUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{userId}/log")
    public ResponseEntity<Void> logAction(@PathVariable Integer userId, @RequestBody String action) {
        userService.logAction(userId, action);
        return ResponseEntity.ok().build();
    }
}
