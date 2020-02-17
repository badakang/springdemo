package com.acorp.springdemo.service;

import com.acorp.springdemo.dao.UserRepository;
import com.acorp.springdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Map getMessage() {
        Map<String, String> res = new HashMap<>();
        res.put("greet", "Hello World");
        return res;
    }

    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserbyId(Integer userid) {
        return userRepository.getUserByUserid(userid);
    }

    public User registUser(User user) {
        System.out.println(user);
        return userRepository.insertUser(user);
    }

    public void modifyUser(Integer userid, User user) {
        user.setUserid(userid);
        userRepository.updateUser(user);
    }

    public void removeUser(Integer userid) {
        userRepository.removeUser(userid);
    }
}
