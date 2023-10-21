package pm;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;
public class Exe_DBUtils {
    public static void main(String[] args) throws Exception {
//        Properties prop = new Properties();
//        prop.load(new FileReader("Properties/DruidProp"));
//        System.out.println(prop.get("driverClassName"));
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        DbUtils.loadDriver("com.mysql.cj.jdbc.Driver");

        QueryRunner queryRunner = new QueryRunner();
        Account account = queryRunner.query(
                DriverManager.getConnection("jdbc:mysql://localhost:3306",
                        "root",""),
                "select * from test.account where name = '叶辉'",
                new BeanHandler<Account>(Account.class));
        System.out.println(account);

    }
}
