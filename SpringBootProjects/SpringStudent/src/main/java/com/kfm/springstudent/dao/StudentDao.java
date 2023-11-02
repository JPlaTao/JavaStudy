package com.kfm.springstudent.dao;

import com.kfm.springstudent.model.Student;
import com.kfm.springstudent.utils.LoadDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public QueryRunner queryRunner = new QueryRunner(LoadDataSource.getDataSource());


    public int delete(int id) throws SQLException {
        String sql = "delete from school.students where id=?";
        return queryRunner.update(sql, id);
    }

    public int update(int id, String name, int age, String gender, String grande)
            throws SQLException {
        String sql = "update school.students set name=?,age=?,gender=?,grande=?" +
                " where id=?";
        return queryRunner.update(sql, name, age, gender, grande, id);
    }

    public int insert(String name, int age, String gender, String grande)
            throws SQLException {
        String sql = "insert into school.students (name,age,gender,grande)" +
                " values(?,?,?,?)";
        return queryRunner.update(sql, name, age, gender, grande);
    }

    public List<Student> selectAll() throws SQLException {
        String sql = "select * from school.students";
        return queryRunner.query(sql, new BeanListHandler<>(Student.class));
    }

    public Student selectById(int id) throws SQLException {
        String sql = "select * from school.students where id=?";
        return queryRunner.query(sql, new BeanHandler<>(Student.class), id);
    }

    /**
     * 查询一页数据
     *
     * @param pageRows   一页的行数
     * @param pageNumber 第几页 页码
     * @return 一页数据的 List
     * @throws SQLException sql 异常
     */
    public List<Student> selectOnePage(Integer pageRows, Integer pageNumber)
            throws SQLException {
        // 返回 查询出一页数据的 list
        String sql = "select * from school.students limit ?,?";
        return queryRunner.query(
                sql, new BeanListHandler<>(Student.class),
                ((pageNumber - 1) * pageRows), pageRows);
    }

    public List<Student> selectOnePageWithCondition(Student student, int pageNum, int pageSize) throws SQLException {
        StringBuilder sql = new StringBuilder(
                "select * from school.student where 1 = 1 ");
        List<Object> params = new ArrayList<>();
        if (student.getName() != null && !student.getName().isEmpty()) {
            sql.append(" and name = ?");
            params.add(student.getName());
        }
        if (student.getAge() != null) {
            sql.append(" and age = ?");
            params.add(student.getAge());
        }
        if (student.getGrande() != null && !student.getGrande().isEmpty()) {
            sql.append(" and grade = ?");
            params.add(student.getGrande());
        }
        if (student.getGender() != null && !student.getGender().isEmpty()) {
            sql.append(" and gender = ?");
            params.add(student.getGender());
        }
        sql.append(" limit ?,? ");
        params.add((pageNum - 1) * pageSize);
        params.add(pageSize);
        return queryRunner.query(sql.toString(),
                new BeanListHandler<Student>(Student.class),
                params.toArray());
    }

    public Long rowsCountWithCondition(Student student) throws SQLException {
        StringBuilder sql = new StringBuilder(
                "select * from school.student where 1 = 1 ");
        List<Object> params = new ArrayList<>();
        if (student.getName() != null && !student.getName().isEmpty()) {
            sql.append(" and name = ?");
            params.add(student.getName());
        }
        if (student.getAge() != null) {
            sql.append(" and age = ?");
            params.add(student.getAge());
        }
        if (student.getGrande() != null && !student.getGrande().isEmpty()) {
            sql.append(" and grade = ?");
            params.add(student.getGrande());
        }
        if (student.getGender() != null && !student.getGender().isEmpty()) {
            sql.append(" and gender = ?");
            params.add(student.getGender());
        }
        sql.append(" limit ?,? ");
        return queryRunner.query(sql.toString(),
                new ScalarHandler<>(),
                params.toArray());
    }

    public Long rowsCount() throws SQLException {
        String SQL = "select count(id) from school.students";
        return queryRunner.query(SQL, new ScalarHandler<>());
    }

}
