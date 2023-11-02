package com.kfm.springstudent.service;

import com.kfm.springstudent.dao.StudentDao;
import com.kfm.springstudent.model.Page;
import com.kfm.springstudent.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    public StudentDao studentDao = new StudentDao();

    public List<Student> findAll() {
        try {
            return studentDao.selectAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Page<Student> findOnePage(
            Integer pageRows, Integer currentPageNumber) {
        try {
            //如果不指定一页的行数，默认为 5
            if (pageRows == null) {
                pageRows = 5;
            }
            //如果不指定第几页，默认第一页
            if (currentPageNumber == null) {
                currentPageNumber = 1;
            }
            List<Student> onePageList =
                    studentDao.selectOnePage(pageRows, currentPageNumber);
            return new Page<Student>(onePageList, currentPageNumber, pageRows,
                    findTotalRowsCount());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Page<Student> findOnePageWithCondition(
            Integer pageRows, Integer currentPageNumber,
            Student student
    ) {
        try {
            //如果不指定一页的行数，默认为 5
            if (pageRows == null) {
                pageRows = 5;
            }
            //如果不指定第几页，默认第一页
            if (currentPageNumber == null) {
                currentPageNumber = 1;
            }
            List<Student> students =
                    studentDao.selectOnePageWithCondition(
                            student, currentPageNumber, pageRows);
            Page<Student> page = new Page<>(students, pageRows, currentPageNumber,
                    findTotalRowsCountWithCondition(student));
            return page;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public long findTotalRowsCount() {
        try {
            return studentDao.rowsCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public long findTotalRowsCountWithCondition(Student student) {
        try {
            return studentDao.rowsCountWithCondition(student);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int deleteStudent(int id) {
        try {
            return studentDao.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int insertStudent(String name, int age, String gender, String grande) {
        try {
            return studentDao.insert(name, age, gender, grande);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int updateStudent(int id, String name, int age, String gender, String grande) {
        try {
            return studentDao.update(id, name, age, gender, grande);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public Student findById(String id) {
        try {
            int byId = Integer.parseInt(id);
            return studentDao.selectById(byId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
