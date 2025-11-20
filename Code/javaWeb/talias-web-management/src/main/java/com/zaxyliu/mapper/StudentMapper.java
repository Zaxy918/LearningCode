package com.zaxyliu.mapper;

import com.github.pagehelper.Page;
import com.zaxyliu.pojo.Student;
import com.zaxyliu.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    Page<Student> queryStudent(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void add(Student student);

    Student queryById(Integer id);

    void alter(Student student);

    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();

    @MapKey("clazz")
    List<Map<String, Object>> countStudentClazz();
}
