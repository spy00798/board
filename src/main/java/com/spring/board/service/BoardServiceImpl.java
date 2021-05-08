package com.spring.board.service;

import com.spring.board.mapper.BoardMapper;
import com.spring.board.vo.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public boolean registerBoard(BoardDTO params) {
            int queryResult = 0;

            if (params.getIdx() == null) {
                queryResult = boardMapper.insertBoard(params);
            } else {
                queryResult = boardMapper.updateBoard(params);
            }

            return (queryResult == 1) ? true:false;
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        int queryResult = 0;

        return boardMapper.selectBoardDetail(idx);
    }
}
