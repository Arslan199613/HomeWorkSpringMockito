package com.example.homeworkmockito.service;
import com.example.homeworkmockito.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDaoImpl userDaoMock;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnTrueIfTheListContainAUser() {
        User user2 = new User("Иван");
        boolean contains = userDaoMock.getUserList().contains(user2);
        when(userDaoMock.getUserList())
                .thenReturn(Collections.emptyList());

        assertEquals(contains, userService.checkUserExist(user2));
    }

    @Test
    public void shouldReturnFalseIfTheListNotContainAUser() {
        User user1 = new User("Михаил");
        when(userDaoMock.getUserList())
                .thenReturn(Collections.emptyList());
        boolean u1 = userService.checkUserExist(user1);

        assertEquals(false, u1);
    }
}