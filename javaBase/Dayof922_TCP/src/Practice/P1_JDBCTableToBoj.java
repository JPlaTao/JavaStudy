package Practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class P1_JDBCTableToBoj {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/kfm";

        try {
            //注册驱动管理
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
        }/* catch (SQLException e) {
            e.printStackTrace();
        }*/ catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //连接数据库
        try (Connection connector = DriverManager.getConnection(url, "root", "");
             Statement statement = connector.createStatement();
        ) {
            //
            ResultSet resultSet = statement.executeQuery("select * from students");

            ResultSetMetaData metaData = resultSet.getMetaData();

            List<Object> resultList = new ArrayList<Object>();


            while (resultSet.next()) {
                //
//                StringBuilder row = new StringBuilder();
                String row = "| ";
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    resultList.add(resultSet.getObject(i));
                    row += (resultSet.getObject(i) + "\t|\t");
                }
                resultList.add(row);
            }
//            resultList.forEach(o -> System.out.println(o.toString()));
            for (Object o : resultList) {
                System.out.println(o.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

class test {

}
