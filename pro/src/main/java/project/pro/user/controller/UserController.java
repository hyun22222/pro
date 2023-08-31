package project.pro.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.pro.mybatis.mappers.Mapper;
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
    public String joinUser(UserDto userDto){
        userService.uploadUser(userDto);

        return "redirect:/";
    }


    @PostMapping("ex")
    public String ex(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/join";
        }
        return "redirect:/join";
    }
}
