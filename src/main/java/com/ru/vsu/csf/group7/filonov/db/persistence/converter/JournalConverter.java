package com.ru.vsu.csf.group7.filonov.db.persistence.converter;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.db.model.Journal;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.sql.ResultSet;
import java.sql.SQLException;

@Injectable
public class JournalConverter implements Converter {

    @Override
    public Subject toSubject(ResultSet resultSet) throws SQLException {
        return new Journal(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getInt("amount"),
                resultSet.getInt("number"),
                resultSet.getDate("date_release").toLocalDate(),
                resultSet.getInt("number_page")
        );
    }

    @Override
    public String insertingToSql(Subject item) {
        return  String.format(
                        "INSERT INTO newsstand (title, amount, type, number, date_release, number_page) " +
                        "VALUES ('%s', %d, '%s', %d, '%s', %d)",
                item.getTitle(), item.getAmount(), item.getType().toString(), ((Journal) item).getNumber(),
                ((Journal) item).getDateRelease().toString(), ((Journal) item).getNumberPage()
        );
    }

    @Override
    public String updatingToSql(Long id, Subject item) {
        return  String.format(
                        "UPDATE newsstand          " +
                        "SET title = '%s',         " +
                        "    amount = %d,          " +
                        "    number = %d,          " +
                        "    date_release = '%s',  " +
                        "    number_page = %d      " +
                        "WHERE id = %d             ",
                item.getTitle(), item.getAmount(), ((Journal) item).getNumber(),
                ((Journal) item).getDateRelease().toString(), ((Journal) item).getNumberPage(), id
        );
    }

    @Override
    public String getType() {
        return TypeSubject.JOURNAL.toString();
    }
}
