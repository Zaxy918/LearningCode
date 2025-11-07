package com.zaxyuserlist.dao.impl;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zaxyuserlist.dao.UserDao;

import cn.hutool.core.io.IoUtil;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> getUserLines() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = new ArrayList<>(IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>()));
        return lines;
    }
}