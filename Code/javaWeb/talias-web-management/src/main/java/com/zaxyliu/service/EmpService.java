package com.zaxyliu.service;

import com.zaxyliu.pojo.Emp;
import com.zaxyliu.pojo.EmpQueryParam;
import com.zaxyliu.pojo.LoginInfo;
import com.zaxyliu.pojo.PageResult;

import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
