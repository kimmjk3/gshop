package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean registerUser(UserDTO params) {
        int queryResult = 0;

        if (params.getUserID() == null) {
            queryResult = userMapper.insertUser(params);
        } else {
            queryResult = userMapper.updateUser(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public UserDTO getUserDetail(String userID) {
        return userMapper.selectUserDetail(userID);
    }

    @Override
    public boolean deleteUser(String userID) {
        int queryResult = 0;

        UserDTO user = userMapper.selectUserDetail(userID);
        if (user != null && user.getUserSecessionDate() == null) {
            queryResult = userMapper.deleteUser(userID);
        }

        return (queryResult == 1) ? true : false;
    }

}
