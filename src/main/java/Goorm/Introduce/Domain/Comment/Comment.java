package Goorm.Introduce.Domain.Comment;

import Goorm.Introduce.Domain.Board.Board;
import lombok.Data;

/**
 * username : 사용자명
 * password : 방명록 등록시 사용할 비밀번호
 * content : 방명록 내용
 * boardId : 게시글 아이디
 */
@Data
public class Comment {
    private String id;
    private String username;
    private String password;
    private String content;
    private String boardId;

}
