package project.pro.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import project.pro.board.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> findAllBoard();

    void uploadBoard(BoardDto boardDto);

    int countBoard();

    List<BoardDto> selectBoard(BoardDto boardDto);
    BoardDto selectDetail(BoardDto boardDto);

    void updateWrite(BoardDto boardDto);

    void deleteWrite(BoardDto boardDto);
}
