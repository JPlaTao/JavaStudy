package Exam06_0923.BookManager;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    static final String URL = "jdbc:mysql://localhost:3306/manager";
    static final String USER = "root";
    static final String PASSWORD = "";
    Scanner scanner = new Scanner(System.in);
    DBUtil dbUtil;

    public BookManager()  {
        try {
            dbUtil = new DBUtil();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ResultSet resultSet = dbUtil.executeQuery("select * from books");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化函数，如果没有 books 和 log 表的话就读取sql文件然后创建表
     *
     * @throws SQLException
     */
    private void init() throws SQLException {
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

    /**
     *
     */
    private DBUtil getDbUtil() throws IOException {
        if (dbUtil == null){
            dbUtil = new DBUtil();
            return dbUtil;
        }
        return dbUtil;
    }


    /**
     * 主菜单，提供主要功能交互面板
     */
    public void mainMenu() {
        System.out.println("""
                ============================
                请输入要进行的操作:
                0.退出系统
                1.新增图书
                2.修改图书数量
                3.删除图书
                4.显示所有图书
                5.查看操作日志
                ============================""");
        int opera = scanner.nextInt();
        switch (opera) {
            case 0 -> System.exit(1);
            case 1 -> {
                addBookInfo();
            }
            case 2 -> {
                try {
                    modifyBookQuantity();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 3 -> {
                try {
                    removeBook();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 4 -> {
                try {
                    showTable("books");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 5 -> {
                try {
                    showTable("operation_log");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        mainMenu();
    }

    /**
     * 交互式地从控制面板获取信息，信息的录入由addBookWithInfo()方法完成
     */
    public void addBookInfo() {
        Scanner scanner = new Scanner(System.in);
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
        boolean i = false;
        try {
            i = addBookWithInfo(title, date, author, price, quantity);
        } catch (SQLException e) {
            e.getCause();
        }
        if (!i) {
            System.out.println("插入成功");
            try {
                log("新增图书 - 书名：" + title);
            } catch (SQLException e) {
                e.getCause();
            }
        } else
            System.out.println("插入失败");
    }

    private boolean addBookWithInfo(String book_title, String publication_date,
                                    String author, double price, int quantity)
            throws SQLException {
        Statement statement = null;
        try {
            statement = getStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String insertSQL = "insert into " +
                "books(book_title,publication_date,author,price,quantity)" +
                "values (" +
                "'" + book_title + "'" + "," +
                "'" + publication_date + "'" + "," +
                "'" + author + "'" + "," +
                price + "," +
                quantity + ")";
        return statement.execute(insertSQL);
    }

    public void removeBook() throws SQLException {
        Statement statement = getStatement();
        String column;
        String value;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入列名：");
            column = scanner.next();
            System.out.print("请输入对应的值：");
            value = scanner.next();
        }
        String delete = "delete from books where " +
                column + " = " +
                "'" + value + "'";
        ResultSet resultSet = statement.executeQuery(
                "select book_title from books where " +
                        column + " = " + "'" + value + "'");
        //没有这句会报 beforeStart 错误
        resultSet.next();
        //获取书名用于添加日志
        String book_title = resultSet.getString(1);
        int i = statement.executeUpdate(delete);
        if (i > 0) {
            System.out.println("成功删除 " + i + " 行");
            //调用 log添加日志
            log("删除图书记录 - 书名：" + book_title);
        } else {
            System.out.println("删除失败");
        }
        closeResources();
    }

    /**
     * 提供删除操作的交互面板
     */
    public void removeBookMenu() {
        System.out.print("""
                请输入指定的列名:
                1.id
                2.书名""");
        int op = scanner.nextInt();
        switch (op) {
            case 1 -> {
                System.out.println("请输入id");
                int id = scanner.nextInt();
                removeBookById(id);
            }
            case 2 -> {
                System.out.println("请输入书名");
                String title = scanner.next();
                removeBookByTitle(title);
            }
        }
    }

    private void removeBookByTitle(String title) {
    }

    private void removeBookById(int id) {

    }

    public void modifyBookQuantity() throws SQLException {
        //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
//        Statement statement = getStatement();
        String title;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入要修改数量的图书名：");
            title = scanner.next();
        }
        ResultSet resultSet = executeQuerySQL(
                "select quantity from books where book_title = "
                        + "'" + title + "'");
        resultSet.next();
        String quantity = resultSet.getString(1);
        int newQuantity;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("请输入修改后的值(数量需比原数量大，原数量：" + quantity + ")：");
            newQuantity = scanner.nextInt();
        }
        String update = "update books set quantity = " +
                newQuantity + " " +
                "where book_title = " +
                "'" + title + "'";
        int i = executeUpdateSQL(update);

        if (i > 0) {
            System.out.println("成功修改 " + i + " 行");
            log("修改图书信息 - 书名：" + title +
                    "  原数量：" + quantity +
                    "  修改后：" + newQuantity);
        } else {
            System.out.println("修改失败");
        }
        closeResources();
        mainMenu();
    }


    private <E> List<E> executeQuery(String sql, Handler<E> handler)
            throws SQLException {
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<E> resultList = new ArrayList<>();
        int count = resultSet.getMetaData().getColumnCount();
        return resultList;
    }

    public void showTable(String tableName) throws SQLException {
//        Statement statement = getStatement();
        ResultSet resultSet = executeQuerySQL("select * from " + tableName);
        String table = "";
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            table += metaData.getColumnLabel(i) + "\t";
            if (i + 1 > metaData.getColumnCount()) {
                table += "\n";
            }
        }
        while (resultSet.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                table += resultSet.getObject(i) + "\t|";
            }
            table += "\n";
        }
        System.out.println(table);
        closeResources();
        mainMenu();
    }

    private void log(String desc) throws SQLException {
//        Statement statement = getStatement();
//        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int i = executeUpdateSQL("insert into operation_log " +
                "(operation_time)" + "values (" + "'" + desc + "'" + ")");
        if (i > 0) {
            System.out.println("添加日志成功 - " + desc);
        } else
            System.out.println("添加日志失败");
        closeResources();
    }

    private boolean executeSQL(String SQL) throws SQLException {
        Statement statement = getStatement();
        return statement.execute(SQL);
    }

    private ResultSet executeQuerySQL(String SQL) throws SQLException {
        Statement statement = getStatement();
        return statement.executeQuery(SQL);
    }

    private int executeUpdateSQL(String SQL) throws SQLException {
        Statement statement = getStatement();
        return statement.executeUpdate(SQL);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    private void closeResources() throws SQLException {
        getConnection().close();
        getStatement().close();
    }
}