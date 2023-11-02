package com.platao.mybatis.dao;

import com.platao.mybatis.model.Student;
import java.util.List;

public interface StudentDao {

    List<Student> selectAll();

    Student selectById(int id);

    List<Student> selectWithCondition(Student student);

    List<Student> selectByNameLike(String name);

    int insert(Student student);

    int insertReturnPrimeKey();

    void delete(int id);

    int updateById(Student student);
}
