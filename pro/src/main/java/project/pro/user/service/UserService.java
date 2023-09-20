package project.pro.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.pro.user.dao.UserDao;
import project.pro.user.dto.LoginDto;
import project.pro.user.dto.UserDto;

import java.util.List;

@Service
public class UserService {
    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){

        this.userDao = userDao;
    }

    public void uploadUser(UserDto userDto){

        userDao.uploadUser(userDto);
    }

    public int idCheck(String id){

        return userDao.idCheck(id);
    }

    public LoginDto session(LoginDto loginDto){

        return userDao.session(loginDto);
    }
}
