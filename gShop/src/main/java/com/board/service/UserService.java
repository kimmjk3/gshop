package com.board.service;

import com.board.domain.UserDTO;

public interface UserService {

    // 회원가입
    public void insertUser(UserDTO params) throws Exception;

    // 로그인
    public UserDTO userLogin(UserDTO params) throws Exception;

}
