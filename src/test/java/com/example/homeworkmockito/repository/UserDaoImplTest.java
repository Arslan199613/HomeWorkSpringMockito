package com.example.homeworkmockito.repository;
import com.example.homeworkmockito.model.User;
import com.example.homeworkmockito.repository.UserDaoImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserDaoImplTest {

    @Autowired
    UserDaoImpl userDao;

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
