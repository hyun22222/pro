package project.pro.user.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "입력하세요.")
    private String id;
    @NotBlank
    private String pw;
    @NotBlank
    private String email;
    @NotBlank
    private String name;

}
