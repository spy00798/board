package com.spring.board.service;

import com.spring.board.mapper.BoardMapper;
import com.spring.board.vo.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

        BoardDTO board = boardMapper.selectBoardDetail(idx);

        if(board != null && "N".equals(board.getDeleteyn())) {
                queryResult = boardMapper.deleteBoard(idx);
        }

        return (queryResult == 1) ? true:false;
    }

    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount();

        if (boardTotalCount > 0) {
                    boardList = boardMapper.selectBoardList();
        }

        return boardList;
    }
}
