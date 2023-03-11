package com.example.homeworkmockito.repository;
import com.example.homeworkmockito.exception.UserListNotExistException;
import com.example.homeworkmockito.model.User;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
public class UserDaoImpl {

    User user = new User();

    private List<User> userList;

    public UserDaoImpl() {
        this.userList = List.of(new User("Иван"), new User("Василий"));
    }

    public User getUserByName(String name) {

        return userList.stream()
                .filter(e -> e.getName().equals(name))
                .findAny()
                .orElse(null);

    }
    public List<User> findAllUser() {
        if (userList == null) {
            throw new UserListNotExistException();
        }
        return userList;
    }
}
