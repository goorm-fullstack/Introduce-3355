package Goorm.Introduce.Domain.FeedBack;

import lombok.Data;

/**
 * 페이지 내용이 담길 객체
 */
@Data
public class FeedBack {
    // DB에서 관리할 아이디
    private String id;
    // 이름
    private String name;
    //역활
    private String role;
    // 작성자 프로필 이미지
    private String profile;
    // 날짜
    private String date;
    // 작성 대상: 누구에 대한 피드백인지
    private String memberId;
    // 작성 내용
    private String content;

}

