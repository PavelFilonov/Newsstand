package com.ru.vsu.csf.group7.filonov.db.persistence.converter;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.db.model.Book;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.sql.ResultSet;
import java.sql.SQLException;

@Injectable
public class BookConverter implements Converter {

    @Override
    public Subject toSubject(ResultSet resultSet) throws SQLException {
        return new Book(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getInt("amount"),
                resultSet.getString("author"),
                resultSet.getString("publisher"),
                resultSet.getInt("number_page")
        );
    }

    @Override
    public String insertingToSql(Subject item) {
        return  String.format(
                        "INSERT INTO newsstand (title, amount, type, author, publisher, number_page) " +
                        "VALUES ('%s', %d, '%s', '%s', '%s', %d)",
                item.getTitle(), item.getAmount(), item.getType().toString(), ((Book) item).getAuthor(),
                ((Book) item).getPublisher(), ((Book) item).getNumberPage()
        );
    }

    @Override
    public String updatingToSql(Long id, Subject item) {
        return  String.format(
                        "UPDATE newsstand       " +
                        "SET title = '%s',      " +
                        "    amount = %d,       " +
                        "    author = '%s',     " +
                        "    publisher = '%s',  " +
                        "    number_page = %d   " +
                        "WHERE id = %d          ",
                item.getTitle(), item.getAmount(), ((Book) item).getAuthor(),
                ((Book) item).getPublisher(), ((Book) item).getNumberPage(), id
        );
    }

    @Override
    public String getType() {
        return TypeSubject.BOOK.toString();
    }
}
