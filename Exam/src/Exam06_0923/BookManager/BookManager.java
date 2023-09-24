package Exam06_0923.BookManager;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookManager {
    static final String URL = "jdbc:mysql://localhost:3306/manager";
    static final String USER = "root";
    static final String PASSWORD = "";
    static Scanner scanner = new Scanner(System.in);

    public BookManager() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement statement = getStatement();
        try {
            statement.executeQuery("select * from books");
            statement.executeQuery("select * from log");
        } catch (SQLSyntaxErrorException e) {
            init();
        }
        closeStatement();
    }

    public void init() throws SQLException {
        Statement statement = getStatement();
        try {
            Reader reader = null;
            reader = new BufferedReader(new FileReader("Exam/sql.txt"));
            char[] buffer = new char[1024];
            int read;
            String all = "";
            while ((read = reader.read(buffer)) != -1) {
                String str = new String(buffer, 0, read);
                all += str;
            }
            String[] split = all.split(";");
            for (int i = 0; i < split.length; i++) {
                statement.execute(split[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBookInfo() {
        try (Scanner scanner = new Scanner(System.in);
             Connection connector = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connector.createStatement();
        ) {
            System.out.print("请输入图书名：");
            String title = scanner.nextLine();
            System.out.print("请输入出版年份：");
            int pubYear = scanner.nextInt();
            System.out.print("请输入出版月份：");
            int pubMonth = scanner.nextInt();
            System.out.print("请输入出版日期：");
            int pubDay = scanner.nextInt();
            String date = pubYear + "-" + pubMonth + "-" + pubDay;
            System.out.print("请输入作者：");
            String author = scanner.next();
            System.out.print("请输入价格：");
            double price = scanner.nextDouble();
            System.out.print("请输入数量：");
            int quantity = scanner.nextInt();
            String insertSQL = "insert into " +
                    "books(book_title,publication_date,author,price,quantity)" +
                    "values (" +
                    "'" + title + "'" + "," +
                    "'" + date + "'" + "," +
                    "'" + author + "'" + "," +
                    price + "," +
                    quantity + ")";
            boolean i = statement.execute(insertSQL);
            if (!i) {
                System.out.println("插入成功");
                log("添加图书" + title);
            } else
                System.out.println("插入失败");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBook() throws SQLException {
        Statement statement = getStatement();
        System.out.print("请输入列名：");
        String column = scanner.next();
        System.out.print("请输入对应的值：");
        String value = scanner.next();
        String delete = "delete from books where " +
                column + " = " +
                "'" + value + "'";
        int i = statement.executeUpdate(delete);
        System.out.println(i > 0 ? ("成功删除 " + i + " 行") : "删除失败");
        closeStatement();
    }

    public void modifyBookQuantity() throws SQLException {
        //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
        Statement statement = getStatement();
        System.out.print("请输入要修改数量的图书名：");
        String title = scanner.next();
        System.out.print("请输入修改后的值：");
        int newQuantity = scanner.nextInt();
        String update = "update books set quantity = " +
                newQuantity + " " +
                "where book_title = " +
                "'" + title + "'";
        int i = statement.executeUpdate(update);
        System.out.println(i > 0 ? "成功修改 " + i + " 行" : "修改失败");
        closeStatement();
    }


    public void showAllBooks() throws SQLException {
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery("select * from books");
        String table = "id\t|\t书名   \t|\t出版日期  \t|\t作者   \t|\t价格   \t|\t数量\t|\n";
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                table += resultSet.getObject(i) + "\t|";
            }
            table += "\n";
        }
        System.out.println(table);
        closeStatement();
    }

    private void log(String desc) throws SQLException {
        Statement statement = getStatement();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        boolean i = statement.execute("insert into operation_log " +
                "(description,operation_time)" +
                "values (" +
                "'" + desc + "'," +
                "'" + time + "'" +
                ")"
        );
        if (!i) {
            System.out.println("添加日志成功");
        } else
            System.out.println("添加日志失败");
        closeStatement();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    private void closeStatement() throws SQLException {
        getStatement().close();
    }
}