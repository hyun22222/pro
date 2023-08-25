package project.pro.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import project.pro.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> findAllBoard();

    void uploadBoard(BoardDto boardDto);

    int countBoard();

    List<BoardDto> selectBoard(BoardDto boardDto);
    BoardDto selectDetail(BoardDto boardDto);

    BoardDto updateWrite(BoardDto boardDto);
}
