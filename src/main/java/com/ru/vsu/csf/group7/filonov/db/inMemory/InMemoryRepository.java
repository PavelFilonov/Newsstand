package com.ru.vsu.csf.group7.filonov.db.inMemory;

import com.ru.vsu.csf.group7.filonov.db.Repository;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryRepository<T extends Subject> implements Repository<T> {
    private Set<T> items;

    public InMemoryRepository(List<T> items) {
        this.items = new HashSet<>(items);
    }

    @Override
    public List<T> selectByType(TypeSubject type) {
        return items.stream()
                .filter(item -> item.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<T> selectByTitle(String title) {
        return items.stream()
                .filter(item -> item.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<T> selectById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> selectAll() {
        return List.copyOf(items);
    }

    @Override
    public boolean insert(T item) {
        return items.add(item);
    }

    @Override
    public boolean updateById(Long id, T item) {
        if (items.contains(item)) {
            deleteById(id);
            insert(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<T> item = selectById(id);
        if (item.isPresent()) {
            items.remove(item);
            return true;
        }
        return false;
    }
}
