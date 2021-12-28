package com.ru.vsu.csf.group7.filonov.db.persistence.converter;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.db.model.Newspaper;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.sql.ResultSet;
import java.sql.SQLException;

@Injectable
public class NewspaperConverter implements Converter {

    @Override
    public Subject toSubject(ResultSet resultSet) throws SQLException {
        return new Newspaper(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getInt("amount"),
                resultSet.getInt("number"),
                resultSet.getDate("date_release").toLocalDate()
        );
    }

    @Override
    public String insertingToSql(Subject item) {
        return  String.format(
                        "INSERT INTO newsstand (title, amount, type, number, date_release) " +
                        "VALUES ('%s', %d, '%s', %d, '%s')",
                item.getTitle(), item.getAmount(), item.getType().toString(), ((Newspaper) item).getNumber(),
                ((Newspaper) item).getDateRelease().toString()
        );
    }

    @Override
    public String updatingToSql(Long id, Subject item) {
        return  String.format(
                        "UPDATE newsstand         " +
                        "SET title = '%s',        " +
                        "    amount = %d,         " +
                        "    number = %d,         " +
                        "    date_release = '%s'  " +
                        "WHERE id = %d            ",
                item.getTitle(), item.getAmount(), ((Newspaper) item).getNumber(),
                ((Newspaper) item).getDateRelease().toString(), id
        );
    }

    @Override
    public String getType() {
        return TypeSubject.NEWSPAPER.toString();
    }
}
