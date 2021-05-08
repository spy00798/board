package com.spring.board;

import com.spring.board.mapper.BoardMapper;
import com.spring.board.vo.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public  void testOfInsert() {
        BoardDTO params = new BoardDTO();
        params.setBdTitle("1번 게시글 제목");
        params.setBdContent("1번 게시글 내용");
        params.setBdWriter("테스터");

        int result = boardMapper.insertBoard(params);
        System.out.println("결과는" + result + "입니다.");
    }
}
