package com.example.homeworkmockito.service;
import com.example.homeworkmockito.exception.UserListNotExistException;
import com.example.homeworkmockito.model.User;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Getter
public class UserDaoImpl {

    private List<User> userList;

    public UserDaoImpl() {
        this.userList = List.of(new User("Иван"), new User("Василий"));
    }

    public User getUserByName(User name) {
        if (name == null) {
            throw new UserListNotExistException();
        }
        return name;
    }

    public List<User> findAllUser() {
        if (userList == null) {
            throw new UserListNotExistException();
        }
        return userList;
    }
}
