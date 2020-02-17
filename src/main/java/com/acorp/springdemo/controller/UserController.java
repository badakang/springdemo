package com.acorp.springdemo.controller;

import com.acorp.springdemo.annotation.TokenRequired;
import com.acorp.springdemo.model.User;
import com.acorp.springdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @TokenRequired
    @GetMapping("")
    public List<User> getAllUser() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")
    public User getUserByUserid(@PathVariable Integer userid) {
        log.debug("userid: "+userid);
        int a = 3/0;
        return userService.getUserbyId(userid);
    }

    @PostMapping("")
    public User registUser (@RequestBody User user) {
        log.debug(user.toString());
        return userService.registUser(user);
    }

    @PutMapping("/{userid}")
    public void modifyUser (
            @PathVariable Integer userid,
            @RequestBody User user) {
        System.out.println("userid: "+userid);
        System.out.println("user: "+user);

        userService.modifyUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser (@PathVariable Integer userid) {
        userService.removeUser(userid);
    }


}
