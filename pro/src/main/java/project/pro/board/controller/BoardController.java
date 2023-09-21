package project.pro.board.controller;

import com.sun.xml.internal.ws.server.ServerRtException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.pro.board.dto.BoardDto;
import project.pro.paging.Paging;
import project.pro.board.service.BoardService;

import javax.servlet.http.HttpSession;
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
    public String write(Model model, HttpSession session){
        model.addAttribute("user", session.getAttribute("user"));

        return "write";
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

    /*@PostMapping("update")
    public String updateWrite(BoardDto boardDto, Model model ){
        boardService.updateWrite(boardDto);
        System.out.println(boardService.selectDetail(boardDto));

        return "redirect:/update";
    }

    @RequestMapping("update")
    public String update(Model model,
                         @RequestParam("uid")int uid){

        BoardDto boardDto = new BoardDto();
        boardDto.setUid(uid);

        model.addAttribute("update",boardService.selectDetail(boardDto));
        return "update";
    }*/

    @PostMapping("test")
    public String test(Model model, @ModelAttribute BoardDto boardDto, RedirectAttributes redirectAttributes){
        boardService.updateWrite(boardDto);
        redirectAttributes.addAttribute("uid",boardService.selectDetail(boardDto).getUid());

        return "redirect:detail";
    }

    @GetMapping("test")
    public String testGet(Model model, @RequestParam int uid) {
        BoardDto boardDto = new BoardDto();
        boardDto.setUid(uid);
        model.addAttribute("update", boardService.selectDetail(boardDto));
        return "update";
    }

    @RequestMapping("delete")
    public String delete(BoardDto boardDto, @RequestParam int uid){
        boardDto.setUid(uid);
        boardService.deleteWrite(boardDto);
        return "redirect:/boardpaging?nowPage=1";

    }


}
