package project.pro.user.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.pro.user.dto.LoginDto;
import project.pro.user.dto.UserDto;
import project.pro.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }

    @RequestMapping("join")
    public String join(Model model){

        return "new";
    }

    @PostMapping("join")
    public String joinUser(@Validated @ModelAttribute UserDto userDto , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "new";
        }

        userService.uploadUser(userDto);

        return "redirect:/";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute UserDto userDto) {

        return "new";
    }

    @PostMapping("session")
    public String session(Model model, HttpSession session, HttpServletRequest request, LoginDto loginDto,
                          @RequestParam String id,
                          @RequestParam String pw){
        loginDto = userService.session(loginDto);
        session = request.getSession();
        if (id.equals(loginDto.getId()) && pw.equals(loginDto.getPw())){
            session.setAttribute("user", loginDto);
            session.setMaxInactiveInterval(300);
            model.addAttribute("user", session.getAttribute("user"));
            return "index";
        }
            return "login";
    }

    @GetMapping("logout")
    public  String logout(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session !=null){
            session.invalidate();
        }
        return "redirect:/login";


    }
}
