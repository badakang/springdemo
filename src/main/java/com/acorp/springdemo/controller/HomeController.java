package com.acorp.springdemo.controller;

import com.acorp.springdemo.service.UserService;
import com.acorp.springdemo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("")
    public String home(){
        return "Hello world";
    }

    @GetMapping("hello")
    public Map<String, String> homeMessge() {
        return this.userService.getMessage();
    }

    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject) {
        String token = securityService.creteToken(subject, 1000 * 60 * 60 * 24L);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", subject);
        map.put("token", token);
        return map;
    }

    @GetMapping("security/get/subject")
    public String getSubject (@RequestParam String token) {
        System.out.println("token: "+token);
        String subject = securityService.getSubject(token);
        return subject;
    }

    @GetMapping("map")
    public Map<String, String> homemap() {
        Map<String, String> res = new HashMap<>();
        res.put("greet", "Hello World"); //Spring boot 에는 json이 내장되어 있어 자동으로 json으로 응답함
        return res;
    }

    @GetMapping("en")
    public String homeen(){
        return "Hello world";
    }

    @GetMapping("kr")
    public String homekr(){
        return "안녕하세요";
    }

}
