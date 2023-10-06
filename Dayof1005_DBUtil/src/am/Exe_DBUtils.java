package am;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Exe_DBUtils {

    Connection connection;
    PreparedStatement preparedStatement;

    public ResultSet query(String preparedSQL, Object... params)
            throws Exception {
        getPreparedStatement(preparedSQL);
        setPreparedStatement(params);
        return preparedStatement.executeQuery();
    }

    public int update(String preparedSQL, Object... param)
            throws Exception {
        getPreparedStatement(preparedSQL);
        setPreparedStatement(param);
        return preparedStatement.executeUpdate();
    }

    private void setPreparedStatement(Object... params)
            throws SQLException {
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
    }

    private Connection getConnection() throws Exception {
        if (connection == null) {
            Properties properties = new Properties();
            properties.load(new FileReader("./Properties/DruidProp"));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            connection = ds.getConnection();
            return connection;
        }
        return connection;
    }

    private void getPreparedStatement(String preparedSQL) throws Exception {
        preparedStatement = getConnection().prepareStatement(preparedSQL);
    }
}
