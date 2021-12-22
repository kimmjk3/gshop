package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.board.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/gshop/write.do")
    public String openBoardWrite(Model model) {

        Integer boardNumber = 1;
        String postTitle = "제목";
        String postContents = "내용";
        Integer postCategory = 1;
        Integer postScore = 5;
        String userID = "idid1234";

        model.addAttribute("boardNumber", boardNumber);
        model.addAttribute("postTitle", postTitle);
        model.addAttribute("postContetns", postContents);
        model.addAttribute("postCategory", postCategory);
        model.addAttribute("postScore", postScore);
        model.addAttribute("userID", userID);

        return "gshop/write";
    }

}