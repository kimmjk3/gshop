package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.UserDTO;

@Mapper
public interface UserMapper {

    // 회원가입
    public void insertUser(UserDTO params);

    // 로그인
    public UserDTO userLogin(UserDTO params);

    public UserDTO selectUserDetail(String userID);

    public int updateUser(UserDTO params);

    public int deleteUser(String userID);

    public List<UserDTO> selectUserList();

}
