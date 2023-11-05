package com.platao.mybatis.dao;

import com.platao.mybatis.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectAll();

    List<Student> selectBasicColumn();

    Student selectById(int id);

    List<Student> selectWithCondition(Student student);

    List<Student> selectWithConditionViaTrim(Student student);

    List<Student> selectByNameLike(String name);

    int insert(Student student);

    int insertReturnPrimeKey();

    int deleteById(int id);

    void deleteByIdIn(String... id);

    int updateById(Student student);

    int updateSet(Student student);
}
