package com.acorp.springdemo.dao;

import com.acorp.springdemo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetAllUser() {
        List<User> res = userRepository.getAllUsers();
        Assert.assertTrue(res.size() > 0);
    }

    @Test
    public void testGetUserByUserid() {
        User user = userRepository.getUserByUserid(100);
        Assert.assertNotNull(user);

    }
}
