package com.example.homeworkmockito.service;
import com.example.homeworkmockito.model.User;
import com.example.homeworkmockito.repository.UserDaoImpl;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    public boolean checkUserExist(User user) {
        if (userDao.getUserList().contains(user)) {
            return true;
        } else {
            return false;
        }
    }
}