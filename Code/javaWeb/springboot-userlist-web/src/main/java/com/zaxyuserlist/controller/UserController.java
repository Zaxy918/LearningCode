package com.zaxyuserlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaxyuserlist.pojo.User;
import com.zaxyuserlist.service.UserService;

@RestController
public class UserController {
    @Autowired //Auto DI
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        return userService.getUserList();
        //Return to frontend
    }
}
