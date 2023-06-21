package Goorm.Introduce.Domain.Board;

import lombok.Data;

@Data
public class Board {
    // DB에서 관라될 Primary Key
    private int id;
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
    private String comments;
}

