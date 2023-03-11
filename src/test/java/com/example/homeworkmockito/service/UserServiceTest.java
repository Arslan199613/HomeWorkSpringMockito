package com.example.homeworkmockito.service;
import com.example.homeworkmockito.model.User;
import com.example.homeworkmockito.repository.UserDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;


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
        User user1 = new User("Иван");
        when(userDaoMock.getUserList())
                .thenReturn(Arrays.asList(user1));

        assertTrue(userService.checkUserExist(user1));
    }

    @Test
    public void shouldReturnFalseIfTheListNotContainAUser() {
        when(userDaoMock.getUserList())
                .thenReturn(Arrays.asList(new User("Вася")));

        assertFalse(userService.checkUserExist(new User("Степа")));
    }
}