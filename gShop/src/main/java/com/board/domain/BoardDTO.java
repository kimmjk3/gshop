package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private Integer postNumber;
    private int boardNumber;
    private String postTitle;
    String postContents;
    int postCategory;
    int postScore;
    String postInputDate;
    String postCorrent;
    String postDeleteDate;
    int postRecommend;
    String userID;
}