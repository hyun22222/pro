package project.pro.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.pro.user.dao.UserDao;
import project.pro.user.dto.UserDto;

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
}
