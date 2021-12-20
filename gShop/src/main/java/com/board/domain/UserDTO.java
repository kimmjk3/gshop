package com.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserDTO {

    private String userID; // 아이디
    private String userPW; // 비밀번호
    private String userName; // 이름
    private int userGender; // 성별 1.남성 2.여성
    private String userDOB; // 생년월일
    private String userAddress1; // 우편번호
    private String userAddress2; // 기본주소
    private String userAddress3; // 상세주소
    private String userPhone; // 연락처
    private String userEmail; // 이메일
    private String userJoinDate; // 가입일
    private String userSecessionDate; // 탈퇴일

    private int user_Authority; // 권한 0.관리자 1. 유저
    private int user_State; // 활동상태 0.탈퇴 1.활동중 2.정지

}