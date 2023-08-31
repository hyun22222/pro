package project.pro.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.pro.board.dto.BoardDto;
import project.pro.mybatis.mappers.Mapper;

import java.util.List;

@Repository
public class BoardDao {
    Mapper mapper;

    @Autowired
    public BoardDao(Mapper mapper){

        this.mapper = mapper;
    }

    public List<BoardDto> findAllBoard(){

        return mapper.findAllBoard();
    }

    public void uploadBoard(BoardDto boardDto){

        mapper.uploadBoard(boardDto);
    }

    public int countBoard(){

        return mapper.countBoard();
    }

    public List<BoardDto> selectBoard(BoardDto boardDto){

        return mapper.selectBoard(boardDto);
    }

    public BoardDto selectDetail(BoardDto boardDto){

        return mapper.selectDetail(boardDto);
    }

    public void updateWrite(BoardDto boardDto){

        mapper.updateWrite(boardDto);
    }

    public void deleteWrite(BoardDto boardDto){

        mapper.deleteWrite(boardDto);
    }


}
