package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper usermapper;

//회원가입 데이터 입력
    @Override
    public void insertUser(UserDTO params) throws Exception {

        usermapper.insertUser(params);

    }

//로그인
    @Override
    public UserDTO userLogin(UserDTO params) throws Exception {

        return usermapper.userLogin(params);
    }

}
