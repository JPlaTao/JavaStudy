package pm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "");
        String sql = "UPDATE account set balance = balance + ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        try{
            connection.setAutoCommit(false);
            ps.setObject(1,-2000);
            ps.setObject(2,1);
            ps.executeUpdate();
            System.out.println("id 1 已转出2000");

            ps.setObject(1,2000);
            ps.setObject(2,2);
            ps.executeUpdate();
            System.out.println("id 2 已转入2000");
            connection.commit();
            System.out.println("事务已提交");
        }catch (SQLException e){
            System.out.println("事务回滚");
            connection.rollback();
        }catch (Exception e){
            System.out.println("事务回滚");
            connection.rollback();
        }
    }
}
