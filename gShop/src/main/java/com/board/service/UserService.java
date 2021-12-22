package com.board.service;

import com.board.domain.UserDTO;

public interface UserService {

    // 회원가입
    public void insertUser(UserDTO params) throws Exception;

}
