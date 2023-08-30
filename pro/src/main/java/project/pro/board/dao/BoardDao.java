package project.pro.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.pro.board.dto.BoardDto;
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

    public void updateWrite(BoardDto boardDto){

        boardMapper.updateWrite(boardDto);
    }

    public void deleteWrite(BoardDto boardDto){

        boardMapper.deleteWrite(boardDto);
    }


}
