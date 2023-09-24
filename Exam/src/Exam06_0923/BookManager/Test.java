package Exam06_0923.BookManager;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException {
        BookManager bookManager = new BookManager();
        bookManager.addBookInfo();
//        bookManager.removeBook();
//        bookManager.modifyBookQuantity();
//        bookManager.showAllBooks();
//        System.out.println(LocalDateTime.now());
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        System.out.println(dateFormat.format(now));
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.format(now);
//        System.out.println(now);
        //获取时间
//        LocalDateTime now = LocalDateTime.now();
////        Date now = new Date();
//        //格式化
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        System.out.println(now);
//        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(date);
    }


}
