package com.platao.mybatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platao.mybatis.dao.StudentDao;
import com.platao.mybatis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    @Autowired
    private StudentDao studentDao;


    public List<Student> findAll() {
        return studentDao.selectAll();
    }

    public Student findOneById(int id) {
        return studentDao.selectById(id);
    }

    public PageInfo<Student> findOnePage(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Student> studentList = studentDao.selectAll();
        return new PageInfo<>(studentList);
    }

    public int removeOneByID(int id) {
        return studentDao.deleteById(id);
    }

    public void update(Student student){
        studentDao.updateSet(student);
    }
}
