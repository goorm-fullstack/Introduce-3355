package Goorm.Introduce.Domain.Comment;

import Goorm.Introduce.Domain.Board.Board;
import lombok.Data;

/**
 * username : 사용자명
 * password : 방명록 등록시 사용할 비밀번호
 * content : 방명록 내용
 * board : Board와 조인해야 함
 */
@Data
public class Comment {
    private int id;
    private String username;
    private String password;
    private String content;
    private Board board;

}
