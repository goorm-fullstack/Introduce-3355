package Goorm.Introduce.Domain.Comment;

import lombok.Data;

/**
 * password : 방명록 등록시 사용할 비밀번호
 * content : 방명록 내용
 */
@Data
public class Comment {
    private String id;
    private String content;
    private String date;

}
