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
    public String session(HttpSession session, HttpServletRequest request, LoginDto loginDto,
                          @RequestParam String id,
                          @RequestParam String pw){
        System.out.println(id + pw);
        loginDto = userService.session(loginDto);
        System.out.println(loginDto);
        session = request.getSession();
        System.out.println(session.getId());
        if (loginDto.getId()==id && loginDto.getPw()==pw){
            session.setAttribute("user", loginDto);
            System.out.println(session.getAttribute("user"));
            session.setMaxInactiveInterval(300);
            return "index";
        }
            return "login";
    }
}
