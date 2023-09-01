package project.pro.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.pro.user.dto.UserDto;
import project.pro.user.service.UserService;

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

    /*public String idCheck(UserDto userDto ,String id){
        userService.idCheck(id);

        if ()

        return "new";
    }*/
}
