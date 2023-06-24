package Goorm.Introduce.Domain.Board;

import Goorm.Introduce.Domain.Comment.Comment;
import lombok.Data;

import java.util.List;

/**
 * 페이지 내용이 담길 객체
 */
@Data
public class Board {
    // DB에서 관리할 아이디
    private String id;
    // 이름
    private String name;
    //역활
    private String role;
    //깃헙 주소
    private String github;
    //관심 분야
    private String favorite;
    //사용가능 언어
    private String lang;
    //짧은 소개글
    private String shortIntro;

    private List<Comment> comment;
}

