package project.pro.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.pro.mybatis.mappers.Mapper;
import project.pro.user.dto.LoginDto;
import project.pro.user.dto.UserDto;

import java.util.List;

@Repository
public class UserDao {
    Mapper mapper;

    @Autowired
    public UserDao(Mapper mapper){

        this.mapper = mapper;
    }

    public void uploadUser(UserDto userDto){

        mapper.uploadUser(userDto);
    }

    public int idCheck(String id){

        return mapper.idCheck(id);
    }

    public LoginDto session(LoginDto loginDto){

        return mapper.session(loginDto);
    }

}
