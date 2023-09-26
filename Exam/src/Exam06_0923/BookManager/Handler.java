package Exam06_0923.BookManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Handler<E> {
    List<E> toObject(ResultSet resultSet) throws SQLException;
}
