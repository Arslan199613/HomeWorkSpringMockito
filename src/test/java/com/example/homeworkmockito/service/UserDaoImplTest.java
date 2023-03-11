package com.example.homeworkmockito.service;
import com.example.homeworkmockito.model.User;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserDaoImplTest {


    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void shouldReturnCollectionOfUserWhenFindAllUsersCalled() {
        List<User> allUser = userDao.findAllUser();
        Assertions.assertEquals(userDao.getUserList(), allUser);
    }

    @Test
    void shouldReturnsTheUserIfExists() {
        User user = new User("Сергей");
        User userByName = userDao.getUserByName(user);
        assertNotNull(userByName);
    }

    @Test
    void shouldReturnsNullIfNotExists() {
        User user = new User(null);
        String name = user.getName();
        assertNull(name);
    }

    @Test
    void shouldCheckIfThereIsAUser() {
        User user = new User("Иван");
        User userByName = userDao.getUserByName(user);
        assertTrue(userDao.getUserList().contains(userByName));

    }
}
