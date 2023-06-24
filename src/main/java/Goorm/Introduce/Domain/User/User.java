package Goorm.Introduce.Domain.User;

import lombok.Data;

/**
 * 로그인할 사용자 정보
 * id : DB에서 관리할 ID
 * username : LoginID
 * password : password
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
}
