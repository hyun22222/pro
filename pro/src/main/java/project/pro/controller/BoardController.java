package project.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.pro.dto.BoardDto;
import project.pro.paging.Paging;
import project.pro.service.BoardService;

import java.util.List;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService){

        this.boardService = boardService;
    }

//    @RequestMapping("/")
//    public String home() {
//        return "index";
//    }


    @RequestMapping("login")
    public String board(Model model){
        List<BoardDto> boardDtoList = boardService.findAllBoard();
        model.addAttribute("boardList",boardDtoList);
        return "Login";
    }

    @RequestMapping("write1")
    public String write(Model model){


        return "Write";
    }


    @PostMapping("upload")
    public String uploadBoard(BoardDto boardDto, Model model ){
        boardService.uploadBoard(boardDto);


        return "redirect:/boardpaging";
    }

    @RequestMapping("boardpaging")
    public String paging(Model model,
                         @RequestParam(value = "nowPage", defaultValue = "1") int nowPage,
                         @RequestParam(value = "cntPerPage", defaultValue = "15")int cntPerPage){
        int total = boardService.countBoard();
        BoardDto boardDto = new BoardDto();
        boardDto.setAbc((nowPage-1)*cntPerPage);


        Paging paging = new Paging(total, nowPage, cntPerPage);



        model.addAttribute("paging", paging);
        model.addAttribute("pagingAll", boardService.selectBoard(boardDto));

        return "BoardList";
    }

    @RequestMapping("detail")
    public String detail(Model model,
                        @RequestParam("uid")int uid){
        BoardDto boardDto = new BoardDto();
        boardDto.setUid(uid);

        model.addAttribute("detail1",boardService.selectDetail(boardDto));
        return "detail";
    }

    @RequestMapping("rewrite")
    public String rewrite(Model model,
                         @RequestParam("uid")int uid){
        BoardDto boardDto = new BoardDto();
        boardDto.setUid(uid);

        model.addAttribute("detail1",boardService.selectDetail(boardDto));
        return "rewrite";
    }

    @RequestMapping("update")
    public String update(Model model,
                          @RequestParam("uid")int uid){
        BoardDto boardDto = new BoardDto();
        boardDto.setUid(uid);
        model.addAttribute("update",boardService.updateWrite(boardDto));

        return "redirect:/detail";

    }

}
