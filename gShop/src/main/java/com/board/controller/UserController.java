package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/gShop/join.do")
    public String openUserJoin(Model model) {
        return "gShop/join";
    }

}
