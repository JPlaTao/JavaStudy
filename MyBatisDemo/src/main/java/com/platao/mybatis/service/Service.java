package com.platao.mybatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platao.mybatis.constance.FileConstants;
import com.platao.mybatis.dao.StudentDao;
import com.platao.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Service {
    StudentDao studentDao;
    SqlSession sqlSession;

    public Service() {
        try (InputStream resource = Resources.getResourceAsStream(FileConstants.MYBATIS_CONFIG)
        ) {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = factoryBuilder.build(resource);
            sqlSession = factory.openSession(true);
            studentDao = sqlSession.getMapper(StudentDao.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

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
}
