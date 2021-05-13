package com.spring.board.controller;


import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    @ResponseBody
    public List<BoardDTO> boardList() {
       return boardService.getBoardList();
    }

    @RequestMapping(value="/writeAction", method=RequestMethod.POST)
    public String writeAction(
            HttpServletRequest req, @RequestParam("file") MultipartFile file,
            @RequestParam("bd_title")String bdTitle,
            @RequestParam("bd_writer")String bdWriter,
            @RequestParam("bd_contents")String bdContent) throws IllegalStateException, IOException {
        String PATH = req.getSession().getServletContext().getRealPath("/") + "resources/";
        if (!file.getOriginalFilename().isEmpty()) {
            file.transferTo(new File(PATH + file.getOriginalFilename()));
        }
        String filename = file.getOriginalFilename();
        return "board";

      //  boardService.registerBoard(null, bdTitle, bdContent, bdWriter, "", "", filename);
    }

    @RequestMapping(value="/board/view", method=RequestMethod.GET)
    public String view() {
        return "board/view";
    }

    @RequestMapping(value="/board/boardView", method=RequestMethod.GET)
    @ResponseBody
    public BoardDTO boardList(@RequestParam("idx")Long idx){
        return boardService.getBoardDetail(idx);
    }
}
