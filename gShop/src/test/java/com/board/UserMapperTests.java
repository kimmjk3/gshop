package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    // 회원가입
    @Test
    public void testOfInsert() {
        UserDTO params = new UserDTO();
        params.setUserID("testid");
        params.setUserPW("123456");
        params.setUserName("테스터");
        params.setUserGender(1);
        params.setUserDOB("19960831");
        params.setUserAddress1("15641");
        params.setUserAddress2("천안 백자빌딩");
        params.setUserAddress3("7층2교육실");
        params.setUserPhone("010-1111-1111");
        params.setUserEmail("test@naver.com");

        int result = userMapper.insertUser(params);

        System.out.println("결과는" + result + "입니다.");

    }

    // 회원조회
    @Test
    public void testOfSelectDetail() {

        UserDTO user = userMapper.selectUserDetail("testid");

        try {
            String userJson = new ObjectMapper().writeValueAsString(user);

            System.out.println("===================");
            System.out.println(userJson);
            System.out.println("===================");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // 수정
    @Test
    public void testOfUpdate() {
        UserDTO params = new UserDTO();
        params.setUserPW("0070");
        params.setUserAddress1("11111");
        params.setUserAddress2("변경된주소1");
        params.setUserAddress3("변경한주소2");
        params.setUserID((String) "testid");

        int result = userMapper.updateUser(params);
        if (result == 1) {
            UserDTO user = userMapper.selectUserDetail((String) "testid");
            try {
                String userJson = new ObjectMapper().writeValueAsString(user);

                System.out.println("===================");
                System.out.println(userJson);
                System.out.println("===================");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }

    // 삭제
    @Test
    public void testOfDelete() {
        int result = userMapper.deleteUser((String) "testid");
        if (result == 1) {
            UserDTO user = userMapper.selectUserDetail((String) "testid");
            try {
                String userJson = new ObjectMapper().writeValueAsString(user);
                System.out.println("===================");
                System.out.println(userJson);
                System.out.println("===================");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }
}
