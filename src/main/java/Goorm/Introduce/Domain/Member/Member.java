package Goorm.Introduce.Domain.Member;

import lombok.Data;

import java.util.List;

/**
 * 조원 정보를 담을 객체
 */
@Data
public class Member {
    private String id;//고유 식별자
    private String name;//사용자 명
    private String profile;//프로파일
    private String profileSrc;//프로파일 이미지 주소
    private String github;//깃허브 주소
    private String role;//역할
    private String favorite;//선호
    private String shortIntro;//소개글
    private List<String> lang;//사용가능한 스펙

    public Member(String id, String name,String profileSrc, String profile, String github, String role, String favorite, String shortIntro, List<String> lang) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.profileSrc = profileSrc;
        this.github = github;
        this.role = role;
        this.favorite = favorite;
        this.shortIntro = shortIntro;
        this.lang = lang;
    }

    public Member(){}
}

