package com.ru.vsu.csf.group7.filonov.db.persistence.converter;

import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Converter {

    Subject toSubject(ResultSet resultSet) throws SQLException;
    String insertingToSql(Subject item);
    String updatingToSql(Long id, Subject item);
    String getType();

}
