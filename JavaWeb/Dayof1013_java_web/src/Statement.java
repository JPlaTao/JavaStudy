import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Statement {
    DataSource ds;
    Statement() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\4.WorkSpace\\JAVA\\java-study\\" +
                "Dayof1013_java_web\\web\\io\\DruidProp.properties"));
        ds = DruidDataSourceFactory. createDataSource(prop);
    }

    Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    void query(String sql) throws SQLException {
        java.sql.Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                System.out.println(resultSet.getObject(i + 1) + "\t");
            }
        }
        statement.close();
    }
}
