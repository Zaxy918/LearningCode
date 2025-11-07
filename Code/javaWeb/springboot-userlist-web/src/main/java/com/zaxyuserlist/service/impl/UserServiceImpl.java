package com.zaxyuserlist.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxyuserlist.pojo.User;
import com.zaxyuserlist.service.UserService;
import com.zaxyuserlist.dao.UserDao;

@Service // Committed to Spring container IOC
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        List<String> lines = userDao.getUserLines();
        List<User> userList = lines.stream().map(line -> {
            String[] fields = line.split(",");
            Integer id = Integer.parseInt(fields[0]);
            String username = fields[1];
            String password = fields[2];
            String name = fields[3];
            Integer age = Integer.parseInt(fields[4]);
            LocalDateTime updateTime = LocalDateTime.parse(fields[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();
        return userList;
    }
}
