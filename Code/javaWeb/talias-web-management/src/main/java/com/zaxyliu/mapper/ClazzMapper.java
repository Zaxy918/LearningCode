package com.zaxyliu.mapper;

import com.github.pagehelper.Page;
import com.zaxyliu.pojo.Clazz;
import com.zaxyliu.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    Page<Clazz> queryClazz(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz queryById(Integer id);

    void alter(Clazz clazz);

    @Select("select id, name, room, begin_date beginDate, end_date endDate, master_id masterId, subject, create_time createTime, update_time updateTime from clazz")
    List<Clazz> list();
}
