package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class BoardMapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testOfInsert() {

//            BoardDTO params = new BoardDTO();
//    
//            params.setBoardNumber(1);
//            params.setPostTitle("1번 게시글 제목");
//            params.setPostContents("1번 게시글 내용");
//            params.setPostCategory(1);
//            params.setPostScore(5);
//            params.setUserID("idid1234");

//        int result = boardMapper.insertBoard(params);
//        System.out.println("결과는 " + result + "입니다");

        for (int i = 1; i <= 50; i++) {

            BoardDTO params = new BoardDTO();
            params.setBoardNumber(1);
            params.setPostTitle(i + "번 게시글 제목");
            params.setPostContents(i + "번 게시글 내용");
            params.setPostCategory(1);
            params.setPostScore(5);
            params.setUserID("idid1234");

            int result = boardMapper.insertBoard(params);
            System.out.println("결과는 " + result + "입니다");
        }

    }

    @Test
    public void testOfSelectDetail() {

        BoardDTO board = boardMapper.selectBoardDetail((long) 1);
        try {
            String boardJson = new ObjectMapper().writeValueAsString(board);

            System.out.println("=========================");
            System.out.println(boardJson);
            System.out.println("=========================");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOfUpdate() {
        BoardDTO params = new BoardDTO();
        params.setPostTitle("1번 게시글 제목을 수정합니다.");
        params.setPostContents("1번 게시글 내용을 수정합니다.");
        params.setPostCategory(2);
        params.setPostScore(4);

        params.setPostNumber(1);

        int result = boardMapper.updateBoard(params);
        if (result == 1) {
            BoardDTO board = boardMapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(board);

                System.out.println("=========================");
                System.out.println(boardJson);
                System.out.println("=========================");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testOfDelete() {

        BoardDTO params = new BoardDTO();

        int result = boardMapper.deleteBoard((long) 1);
        if (result == 1) {
            BoardDTO board = boardMapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(board);

                System.out.println("=========================");
                System.out.println(boardJson);
                System.out.println("=========================");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testMultipleInsert() {
        for (int i = 2; i <= 50; i++) {
            BoardDTO params = new BoardDTO();
            params.setBoardNumber(1);
            params.setPostTitle(i + "번 게시글 제목");
            params.setPostContents(i + "번 게시글 내용");
            params.setPostCategory(1);
            params.setPostScore(5);
            params.setUserID("idid1234");
        }
    }

    @Test
    public void testSelectList() {
        int boardTotalCount = boardMapper.selectBoardTotalCount();
        if (boardTotalCount > 0) {
            List<BoardDTO> boardList = boardMapper.selectBoardList();
            if (CollectionUtils.isEmpty(boardList) == false) {
                for (BoardDTO board : boardList) {
                    System.out.println("=========================");
                    System.out.println(board.getBoardNumber() + "번 게시판");
                    System.out.println("제목 : " + board.getPostTitle());
                    System.out.println("내용 : " + board.getPostContents());
                    System.out.println("카테고리 : " + board.getPostCategory());
                    System.out.println("별점 : " + board.getPostScore());
                    System.out.println("작성자 : " + board.getUserID());
                    System.out.println("=========================");
                }
            }
        }
    }

}