package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtils;

import java.util.List;

public class UserDao {
    public static boolean isExist(String... params) {
        User user = null;
        try {
            QueryRunner queryRunner = DBUtils.getQueryRunner();
            user = queryRunner.query(
                    "select username from website.users " +
                            "where username = ? and " +
                            "password = ?",
                    new BeanHandler<>(User.class),
                    params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (user != null);
    }

    public static boolean insert(String... params) {
        int result = 0;
        try {
            QueryRunner queryRunner = DBUtils.getQueryRunner();
            result = queryRunner.execute(
                    "insert into website.users(username, password, email)" +
                            " values(?,?,?)",
                    (Object[]) params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result >= 1;
    }

    public static List<User> selectAll(){
        List<User> userList = null;
        try {
            QueryRunner queryRunner = DBUtils.getQueryRunner();
            userList = queryRunner.query("select * from website.users",
                    new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

}
