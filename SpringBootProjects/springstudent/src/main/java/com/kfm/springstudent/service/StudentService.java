package com.kfm.springstudent.service;

import com.kfm.springstudent.dao.StudentDao;
import com.kfm.springstudent.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    public StudentDao studentDao=new StudentDao();

    public List<Student> findAll(){
        try {
            return studentDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> findOnePage(int rows,int offset){
        try {
            return studentDao.selectAllLimit(10, 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int deleteStudent(int id){
        try {
            return studentDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int insertStudent(String name,int age,String gender,String grande){
        try {
            return studentDao.insert(name,age,gender,grande);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int updateStudent(int id,String name,int age,String gender,String grande){
        try {
            return studentDao.update(id,name,age,gender,grande);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public Student findById(String id){
        try {
            int byId=Integer.parseInt(id);
            return studentDao.selectById(byId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
