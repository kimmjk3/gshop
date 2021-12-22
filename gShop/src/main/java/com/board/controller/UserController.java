package com.board.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.domain.UserDTO;
import com.board.service.UserService;

@Controller // 해당 클래스를 컨트롤러로 동작
public class UserController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    // 회원가입 페이지이동
    @GetMapping(value = "/gshop/join.do")
    public void openUserJoin() {

        logger.info("회원가입페이지 진입");
    }

    // 회원가입
    @PostMapping(value = "/gshop/join.do")
    public String joinPOST(UserDTO params) throws Exception {
        logger.info("join 진입");
        // 회원가입 서비스 실행
        userService.insertUser(params);
        logger.info("join Service 성공");
        return "gshop/join";
    }

    // 로그인 페이지이동
    @GetMapping("/gshop/login.do")
    public void openLogin() {
        logger.info("로그인페이지 진입");
    }

}
