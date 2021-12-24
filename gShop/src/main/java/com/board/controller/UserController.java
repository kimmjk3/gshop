package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.domain.UserDTO;
import com.board.service.UserService;

@Controller // 해당 클래스를 컨트롤러로 동작
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/gshop/join.do") // 회원가입 주소
    public String openUserJoin(Model model) {
        System.out.println("회원가입 페이지 진입");
        model.addAttribute("user", new UserDTO());
        return "gshop/join";
    }

    @PostMapping(value = "/gshop/join.do")
    public String registerUser(UserDTO params) {
        try {
            System.out.println("접속테스트");
            boolean isRegistered = userService.registerUser(params);
            if (isRegistered == false) {
                // TODO=> 회원가입 등록 실패하였다는 메시지 전달
                System.out.println("회원가입 실패");
            }
        } catch (DataAccessException e) {
            // TODO=> 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
            System.out.println("데이터베이스 처리 오류");
            e.printStackTrace();
        } catch (Exception e) {
            // TODO=> 시스템에 문제가 발생하였다는 메시지 전달
            System.out.println("시스템에 문제가 발생");
        }
        return "redirect:/gshop/login.do";
    }

    @GetMapping(value = "/gshop/login.do") // 로그인 주소
    public String openUserLogin(Model model) {
        System.out.println("로그인페이지 진입");
        return "gshop/login";
    }

}
