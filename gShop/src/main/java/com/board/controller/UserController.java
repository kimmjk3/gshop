package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.board.service.UserService;

@Controller // 해당 클래스를 컨트롤러로 동작
public class UserController {
    @Autowired
    private UserService userService;

    // 회원가입 매핑
    @GetMapping(value = "/gshop/join.do")
    public String openUserJoin(Model model) {
        return "gshop/join";
    }

    // 로그인 매핑
    @GetMapping("/gshop/login.do")
    public String openLogin(Model model) {
        return "gshop/login";
    }

}
