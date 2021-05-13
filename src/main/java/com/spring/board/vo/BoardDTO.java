package com.spring.board.vo;

import lombok.*;

@Getter
@Setter
public class BoardDTO {

    private Long idx;
    private String bdTitle;
    private String bdContent;
    private String bdWriter;
    private String bdDate;
    private String deleteYn;
    private String bdImage;

}
