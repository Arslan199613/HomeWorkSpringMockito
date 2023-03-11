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

        assertNotNull(userDao.getUserByName("Иван"));
    }

    @Test
    void shouldReturnsNullIfNotExists() {

        assertNull(userDao.getUserByName(null));
    }

    @Test
    void shouldCheckIfThereIsAUser() {

        assertTrue(userDao.getUserList().contains(new User("Иван")));

    }
}
