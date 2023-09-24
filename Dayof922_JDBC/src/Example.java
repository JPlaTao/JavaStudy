import java.sql.*;

public class Example {
    public static void main(String[] args) throws SQLException {
        //TODO 1.注册数据库驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //数据库连接字符串
        String url = "jdbc:mysql://localhost:3306/kfm";
        try (//TODO 2.与数据库建立连接(构建连接对象)
             Connection connector = DriverManager.getConnection(url, "root", "");
             //TODO 4.构建执行 SQL的对象
             Statement statement = connector.createStatement();
        ) {
            //TODO 3.写 SQL语句
//            String insert = "insert into students values (77,'bb',33,'female','A')";
//            String delete = ""
            //执行
            //增
            statement.executeUpdate(
                    "insert into students values (77,'bb',33,'female','A')");

            ResultSet resultSet = statement.executeQuery("select * from students");
//            System.out.println(resultSet.toString());
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

            }
            resultSet.close();

            //删
//            statement.execute(
//                    "delete from students where id = 77");
//            resultSet = statement.executeQuery("select * from students");
//            System.out.println(resultSet.toString());
//            resultSet.close();

            //改
//            statement.execute(
//                    "update id = 66 where id = 6");
//            resultSet = statement.executeQuery("select * from students");
//            System.out.println(resultSet.toString());
//            resultSet.close();
//            if (i > 0) {
//                System.out.println("成功");
//            } else
//                System.out.println("失败");
        }
    }
}
