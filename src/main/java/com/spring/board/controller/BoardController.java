package com.spring.board.controller;


import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/board/insert", method= RequestMethod.GET)
    public String boardInsert() {
        return "board/insert";
    }

    @RequestMapping(value = "/board/list", method=RequestMethod.GET)
    public String boardSelect() {
        return "board/list";
    }

    @RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
    public List<BoardDTO> boardList() {
       return boardService.getBoardList();
    }
}
