package com.ru.vsu.csf.group7.filonov.db.persistence;

import com.ru.vsu.csf.group7.filonov.db.Repository;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.db.persistence.converter.ConverterFactory;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JDBCRepository implements Repository<Subject> {

    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    private Extractor<Subject> extractor = rs -> {
        List<Subject> items = new ArrayList<>();
        while (rs.next()) {
            items.add(ConverterFactory.getInstance().getConverter(rs.getString("type")).toSubject(rs));
        }
        return items;
    };

    @Override
    public Optional<Subject> selectById(Long id) {
        final List<Subject> items = select(String.format("SELECT * FROM newsstand WHERE id = %d;", id), extractor);
        return items.size() > 0 ? Optional.ofNullable(items.get(0)) : Optional.empty();
    }

    @Override
    public List<Subject> selectByTitle(String title) {
        return select(String.format("SELECT * FROM newsstand WHERE title = '%s';", title), extractor);
    }

    @Override
    public List<Subject> selectByType(TypeSubject type) {
        return select(String.format("SELECT * FROM newsstand WHERE type = '%s';", type.toString()), extractor);
    }

    @Override
    public List<Subject> selectAll() {
        return select("SELECT * FROM newsstand;", extractor);
    }

    private List<Subject> select(String query, Extractor<Subject> extractor) {
        try (
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            return extractor.extract(resultSet);
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public boolean insert(Subject item) {
        return update(ConverterFactory.getInstance().getConverter(item.getType().toString()).insertingToSql(item));
    }

    @Override
    public boolean updateById(Long id, Subject item) {
        return update(ConverterFactory.getInstance().getConverter(item.getType().toString()).updatingToSql(id, item));
    }

    @Override
    public boolean deleteById(Long id) {
        return update(String.format("DELETE FROM newsstand WHERE id = %d;", id));
    }

    private boolean update(String query) {
        try (
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());
            return false;
        }
    }
}
