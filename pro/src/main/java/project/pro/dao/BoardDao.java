package project.pro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.pro.dto.BoardDto;
import project.pro.mybatis.mappers.BoardMapper;

import java.util.List;

@Repository
public class BoardDao {
    BoardMapper boardMapper;

    @Autowired
    public BoardDao(BoardMapper boardMapper){

        this.boardMapper = boardMapper;
    }

    public List<BoardDto> findAllBoard(){

        return boardMapper.findAllBoard();
    }

    public void uploadBoard(BoardDto boardDto){

        boardMapper.uploadBoard(boardDto);
    }

    public int countBoard(){

        return boardMapper.countBoard();
    }

    public List<BoardDto> selectBoard(BoardDto boardDto){

        return boardMapper.selectBoard(boardDto);
    }

    public BoardDto selectDetail(BoardDto boardDto){

        return boardMapper.selectDetail(boardDto);
    }

    public BoardDto updateWrite(BoardDto boardDto){

        return boardMapper.updateWrite(boardDto);
    }




}
