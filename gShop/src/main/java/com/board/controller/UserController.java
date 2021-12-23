package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "gshop/login";
    }

    // 로그인 페이지이동
    @GetMapping("/gshop/login.do")
    public void openLogin() {
        logger.info("로그인페이지 진입");
    }

    // 로그인
    @PostMapping(value = "/gshop/login.do")
    public String loginPOST(HttpServletRequest request, UserDTO params, RedirectAttributes rttr) throws Exception {

        // System.out.println("login 메서드 진입");
        // System.out.println("전달된 데이터:" + params);

        HttpSession session = request.getSession();
        UserDTO lvo = userService.userLogin(params);

        if (lvo == null) { // 일치하지 않는 아이디, 비밀번호 입력한 경우
            int result = 0;
            rttr.addFlashAttribute("result", result);
            return "gshop/login";
        }
        session.setAttribute("params", lvo); // 일치하는 아이디, 비밀번호 입력 경우(로그인 성공)

        return "gshop/main";
    }
}
