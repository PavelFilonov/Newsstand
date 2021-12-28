package com.ru.vsu.csf.group7.filonov.db;

import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Subject> {

    Optional<T> selectById(Long id);
    List<T> selectByTitle(String title);
    List<T> selectByType(TypeSubject type);
    List<T> selectAll();
    boolean insert(T item);
    boolean updateById(Long id, T item);
    boolean deleteById(Long id);

}
