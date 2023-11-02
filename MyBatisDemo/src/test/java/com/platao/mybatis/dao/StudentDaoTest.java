package com.platao.mybatis.dao;

import com.platao.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

public class StudentDaoTest {

    StudentDao studentDao;
    SqlSession sqlSession;


    @Before
    public void setUp() throws Exception {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(resource);
        sqlSession = factory.openSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAll() {
        System.out.println(studentDao.selectAll());
    }

    @Test
    public void selectById() {
        System.out.println(studentDao.selectById(10));
    }

    @Test
    public void updateById() {
        studentDao.updateById(new Student(10,"恩拾",new Date(),"女"));
    }

    @Test
    public void delete() {
        studentDao.delete(32);
    }

    @Test
    public void insert() {
        studentDao.insert(new Student("翠花",new Date(),"女"));
    }

    @Test
    public void selectWithCondition() {
        Student student = new Student();
        student.setName("张三");
        System.out.println(studentDao.selectWithCondition(student));
    }
}