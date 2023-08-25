package project.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.pro.dao.BoardDao;
import project.pro.dto.BoardDto;

import java.util.List;

@Service
public class BoardService {
    BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao){

        this.boardDao = boardDao;
    }

    public List<BoardDto> findAllBoard(){

        return boardDao.findAllBoard();
    }

    public void uploadBoard(BoardDto boardDto){

        boardDao.uploadBoard(boardDto);
    }

    public int countBoard(){

        return boardDao.countBoard();
    }

    public List<BoardDto> selectBoard(BoardDto boardDto){

        return boardDao.selectBoard(boardDto);
    }

    public BoardDto selectDetail(BoardDto boardDto){

        return boardDao.selectDetail(boardDto);
    }

    public BoardDto updateWrite(BoardDto boardDto){

        return boardDao.updateWrite(boardDto);
    }



}
