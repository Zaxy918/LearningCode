package com.zaxyliu.controller;

import com.zaxyliu.pojo.Emp;
import com.zaxyliu.pojo.LoginInfo;
import com.zaxyliu.pojo.Result;
import com.zaxyliu.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("Log in {}", emp);
        LoginInfo loginInfo = empService.login(emp);
        if (loginInfo != null) {
            return Result.success(loginInfo);
        }
        return Result.error("Username or password is wrong");
    }
}
