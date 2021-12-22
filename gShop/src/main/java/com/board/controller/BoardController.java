package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/gshop/write.do")
    public String openBoardWrite(@RequestParam(value = "postNumber", required = false) Integer postNumber,
            Model model) {
        if (postNumber == null) {
            model.addAttribute("board", new BoardDTO());
        } else {
            BoardDTO board = boardService.getBoardDetail(postNumber);
            if (board == null) {
                return "redirect:/gshop/list.do";
            }
            model.addAttribute("board", board);
        }

        return "gshop/write";
    }

    @PostMapping(value = "/gshop/register.do")
    public String registerBoard(final BoardDTO params) {
        try {
            boolean isRegistered = boardService.registerBoard(params);
            if (isRegistered == false) {
                System.out.println("게시글 등록 실패");
                // TODO => 게시글 등록에 실패하였다는 메시지를 전달
            }
        } catch (DataAccessException e) {
            System.out.println("게시글 번호 : " + params.getPostNumber());
            System.out.println(params.getUserID());
            System.out.println(params.getBoardNumber());
            System.out.println(params.getPostCategory());
            System.out.println(params.getPostScore());
            System.out.println(params.getPostTitle());
            System.out.println(params.getPostContents());
            System.out.println("DB처리 문제");
            // TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

        } catch (Exception e) {
            System.out.println("시스템 문제");
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
        }

        return "redirect:/gshop/list.do";
    }

    @GetMapping(value = "/gshop/list.do")
    public String openBoardList(Model model) {
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "gshop/list";
    }
}