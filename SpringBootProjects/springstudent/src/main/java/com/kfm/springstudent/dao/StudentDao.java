package com.kfm.springstudent.dao;

import com.kfm.springstudent.model.Student;
import com.kfm.springstudent.utils.LoadDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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

    public List<Student> selectAllLimit(int rows, int offset)
            throws SQLException {
        String sql = "select * from school.students limit ? offset ?";
        return queryRunner.query(sql, new BeanListHandler<>(Student.class),
                rows, offset);
    }
}
