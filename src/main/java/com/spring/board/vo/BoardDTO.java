package com.spring.board.vo;

import lombok.*;

@Getter
@Setter
public class BoardDTO {

    private int idx;
    private String bdTitle;
    private String bdContent;
    private String bdWriter;
    private String bdDate;
}
