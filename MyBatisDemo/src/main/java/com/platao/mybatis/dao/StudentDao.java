package com.platao.mybatis.dao;

import com.platao.mybatis.model.Student;
import java.util.List;

public interface StudentDao {

    List<Student> selectAll();

    Student selectById(int id);

    List<Student> selectWithCondition(Student student);

    int insert(Student student);

    void delete(int id);

    int updateById(Student student);
}
