package com.ru.vsu.csf.group7.filonov.service;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.util.List;

@Injectable
public class BookService extends Service {

    @Override
    public List<Subject> get() {
        return getRepository().selectByType(TypeSubject.BOOK);
    }

    @Override
    public TypeSubject getType() {
        return TypeSubject.BOOK;
    }
}
