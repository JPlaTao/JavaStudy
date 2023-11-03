package com.platao.mybatis.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;


public class StudentDaoTest {

    StudentDao studentDao;
    SqlSession sqlSession;


    @Before
    public void setUp() throws Exception {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(resource);
        sqlSession = factory.openSession(true);
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @After
    public void tearDown() throws Exception {
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAll() {
        //PageHelper.startPage() 方法会对紧跟着的一个 mybatis查询分页，返回的值类型实际为 Page<E>
//        PageHelper.startPage(1, 5);
//        List<Student> students = studentDao.selectAll();
//        System.out.println("\n students: " + students);

        PageHelper.startPage(1,10);
        List<Student> studentsList = studentDao.selectAll();
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentsList);
        System.out.println(studentPageInfo);

    }

    @Test
    public void selectById() {
        System.out.println(studentDao.selectById(10));
    }

    @Test
    public void updateById() {
        studentDao.updateById(new Student(10, "恩拾", new Date(), "女"));
    }

    @Test
    public void delete() {
        studentDao.delete(32);
    }

    @Test
    public void insert() {
        studentDao.insert(new Student("翠花", new Date(), "女"));
    }

    @Test
    public void selectWithCondition() {
        Student student = new Student();
        student.setName("张三");
        System.out.println(studentDao.selectWithCondition(student));
    }

    @Test
    public void selectByNameLike() {
        System.out.println(studentDao.selectByNameLike("a"));
    }

    @Test
    public void deleteByIdIn() {
        studentDao.deleteByIdIn("1", "2", "3");
    }

    @Test
    public void updateSet() {
//        System.out.println(studentDao.updateSet(
//                new Student(47, "小芳", new Date(990892800000L), "女")));
        Student student = new Student();
        student.setId(8);
        student.setName("强子");
        student.setGender("男");
        student.setBirth(new Date(1034058101000L));
        System.out.println(studentDao.updateSet(student));

    }

    @Test
    public void selectBasicColumn() {
        System.out.println(studentDao.selectBasicColumn());
    }

    @Test
    public void selectWithConditionViaTrim() {
        Student student = new Student();
        student.setName("张三");
        System.out.println(studentDao.selectWithCondition(student));
    }
}