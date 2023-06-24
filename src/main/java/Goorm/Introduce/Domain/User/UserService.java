package Goorm.Introduce.Domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User login(String loginId, String password) {
        return userRepository.findByUsername(loginId)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}
