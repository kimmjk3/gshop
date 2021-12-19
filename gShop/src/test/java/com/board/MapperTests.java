package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;

@SpringBootTest
class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testOfInsert() {
        BoardDTO params = new BoardDTO();

        params.setBoardNumber(1);
        params.setPostTitle("1번 게시글 제목");
        params.setPostContents("1번 게시글 내용");
        params.setPostCategory(1);
        params.setPostScore(5);
        params.setUserID("idid1234");

        int result = boardMapper.insertBoard(params);
        System.out.println("결과는 " + result + "입니다.");
    }

}