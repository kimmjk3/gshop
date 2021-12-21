package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean JoinUser(UserDTO params) {
        int queryResult = 0;

        if (params.getUserID() == null) {
            queryResult = userMapper.insertUser(params);
        } else {
            queryResult = userMapper.updateUser(params);
        }

        return (queryResult == 1) ? true : false;
    }

}
