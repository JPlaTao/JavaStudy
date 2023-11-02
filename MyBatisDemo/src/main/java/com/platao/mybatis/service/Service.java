package com.platao.mybatis.service;

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
    {
        try (InputStream resource = Resources.getResourceAsStream("mybatis-config.xml")
        ) {
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = factoryBuilder.build(resource);
            SqlSession sqlSession = factory.openSession();
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
}
