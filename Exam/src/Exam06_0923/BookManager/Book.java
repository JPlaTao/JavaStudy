package Exam06_0923.BookManager;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Data
public class Book {
    private int id;
    private String book_title;
    private Date publication_date;
    private String author;
    private double price;
    private int quantity;

    static class TableToList implements Handler<Book> {
        @Override
        public List<Book> toObject(ResultSet resultSet) throws SQLException {
            List<Book> books = null;
            while (resultSet.next()) {
                Book row = new Book();
                row.setId(resultSet.getInt("id"));
                row.setBook_title(resultSet.getString("book_title"));
                row.setAuthor(resultSet.getString("author"));
                row.setPublication_date(resultSet.getDate("publication_date"));
                row.setQuantity(resultSet.getInt("quantity"));
                books.add(row);
            }
            return books;
        }
    }
}

