package com.acorp.springdemo.service;

import com.acorp.springdemo.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    public Map getMessage();

    public List<User> getUsers();

    public User getUserbyId(Integer userid);

    public User registUser(User user);

    public void modifyUser(Integer userid, User user);

    public void removeUser(Integer userid);
}
