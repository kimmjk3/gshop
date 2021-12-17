package com.board.dmain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private int post_Number;
    private int board_Number;
    private String post_Title;
    String post_Contents;
    int post_Category;
    int post_Score;
    String post_InputDate;
    String post_Corrent;
    String post_DeleteDate;
    int post_Recommend;
    int user_ID;
}