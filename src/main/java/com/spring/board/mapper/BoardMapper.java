package com.spring.board.mapper;

import com.spring.board.vo.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {

    public int insertBoard(BoardDTO params);

    public BoardDTO selectBoardDetail(long idx);

    public int updateBoard(BoardDTO params);

    public int deleteBoard(long idx);

    public List<BoardDTO> selectBoardList();

}
