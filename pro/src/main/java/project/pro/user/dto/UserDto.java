package project.pro.user.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {

    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,20}$",
            message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
    private String id;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    private String pw;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;


}
