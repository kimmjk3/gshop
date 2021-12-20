package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;

@SpringBootTest
class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

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

        System.out.println("결과:" + result + "입니다.");

    }
}
