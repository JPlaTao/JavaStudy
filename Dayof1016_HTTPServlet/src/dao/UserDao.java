package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDao {
    public static boolean isExist(String username) {
        User user = null;
        try {
            QueryRunner queryRunner = Utils.getQueryRunner();
            user = queryRunner.query(
                    "select username from website.users where username = ?",
                    new BeanHandler<>(User.class),
                    username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (user != null);
    }

    public static boolean insert(String... params) {
        int result = 0;
        try {
            QueryRunner queryRunner = Utils.getQueryRunner();
            result = queryRunner.execute(
                    "insert into website.users(username, password, email)" +
                            " values(?,?,?)",
                    (Object[]) params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result >= 1;
    }
}
