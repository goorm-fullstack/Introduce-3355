package Goorm.Introduce.Domain.User;

import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 테스트용 리포지토리입니다.
 */
@Repository
public class UserRepository {
    private static Map<Integer, User> data = new HashMap<>();
    private static int sequence = 0;

    public void save(User user) {
        user.setId(++sequence);
        data.put(user.getId(), user);
    }
    public User findById(int id) {
        return data.get(id);
    }
    public User findByUsernameAndPassword(String username, String password) {
        int index = 1;
        while (true) {
            if(data.get(index)==null)
                break;

            User user = data.get(index);
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
            else
                index++;
        }

        return null;//로그인할 정보가 없다면
    }

    public Optional<User> findByUsername(String loginId) {
        return findAll().stream()
                .filter(user -> user.getUsername().equals(loginId))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(data.values());
    }
}
