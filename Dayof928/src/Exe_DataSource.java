import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Exe_DataSource {
    public static void main(String[] args) {
        try {
//            Connection connection = getConnectionByDruid();
//            System.out.println(connection);
//            Connection c3P0 = getConnectionByC3P0viaXml("hello C3P0");
//            ResultSet resultSet = c3P0.prepareStatement("select * from test.account")
//                    .executeQuery();
//
//            while (resultSet.next()) {
//                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
//                    System.out.println(resultSet.getString(i + 1));
//                }
//            }

            Connection dbcp = getConnectionByDBCP();
            ResultSet resultSet = dbcp.createStatement().executeQuery(
                    "select * from manager.books");
            while (resultSet.next()){
                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                    System.out.println(resultSet.getString(i + 1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection getConnectionByDruid() throws Exception {
        Properties druidProp = new Properties();
        druidProp.load(new FileInputStream("./Properties/DruidProp"));
        DataSource ds = DruidDataSourceFactory.createDataSource(druidProp);
        return ds.getConnection();
    }

    private static Connection getConnectionByC3P0() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306");
        cpds.setUser("root");
        cpds.getPassword();
        cpds.setInitialPoolSize(10);
        return cpds.getConnection();
    }

    private static Connection getConnectionByC3P0viaXml(String name) throws SQLException {
        DataSource cpds = new ComboPooledDataSource(name);
        return cpds.getConnection();
    }

    private static Connection getConnectionByDBCP() throws SQLException {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        source.setUsername("root");
        source.setPassword("");
        source.setInitialSize(10);
        return source.getConnection();
    }



}
