package Exam06_0923.BookManager;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBUtil {

    public DBUtil() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("D:\\4.WorkSpace\\JAVA\\java-study\\Exam\\src\\Exam06_0923\\BookManager\\user.properties"));
        URL = properties.getProperty("url");
        USER_NAME = properties.getProperty("user_name");
        PASSWORD = properties.getProperty("password");
    }
    private final String URL;
    private final String USER_NAME;
    private final String PASSWORD;

    private Connection connector;
    private Statement statement;

    private Connection getConnection()
            throws SQLException, ClassNotFoundException {
        if (connector == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        return connector;
    }

    private Statement getStatement()
            throws SQLException, ClassNotFoundException {
        if (statement == null) {
            return statement = getConnection().createStatement();
        }
        return statement;
    }

    public <E> List<E> executeQuery(String sql, Handler<E> handler)
            throws SQLException, ClassNotFoundException {
        return handler.toObject(getStatement().executeQuery(sql));
    }

    public <E> List<E> executeQuery(String sql,Handler<E> handler,Object... values)
            throws SQLException, ClassNotFoundException {
        try(PreparedStatement preparedStatement =
                    getConnection().prepareStatement(sql)){
            setObject(preparedStatement);
            return handler.toObject(preparedStatement.executeQuery());
        }
    }

    public int executeUpdate(String sql)
            throws SQLException, ClassNotFoundException {
        return getStatement().executeUpdate(sql);
    }

    public int executeUpdate(String sql,Object... values)
            throws SQLException, ClassNotFoundException {
        try(PreparedStatement preparedStatement =
                    getConnection().prepareStatement(sql)){
            setObject(preparedStatement,values);
            return preparedStatement.executeUpdate();
        }
    }

    private void setObject(PreparedStatement pS,Object... values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            pS.setObject(i + 1,values[i]);
        }
    }

    public void close() throws SQLException {
        if (!connector.isClosed())
            connector.close();
        if (!statement.isClosed()){
            statement.close();
        }
    }
}
