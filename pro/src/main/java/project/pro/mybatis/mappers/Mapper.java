package project.pro.mybatis.mappers;

import project.pro.board.dto.BoardDto;
import project.pro.user.dto.UserDto;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    List<BoardDto> findAllBoard();

    void uploadBoard(BoardDto boardDto);

    int countBoard();

    List<BoardDto> selectBoard(BoardDto boardDto);
    BoardDto selectDetail(BoardDto boardDto);

    void updateWrite(BoardDto boardDto);

    void deleteWrite(BoardDto boardDto);
    //dddddddddddddddddddddddddd

    void uploadUser(UserDto userDto);

    int idCheck(String id);


}
