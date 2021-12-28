package com.ru.vsu.csf.group7.filonov.ui.console.page;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.factory.service.ServiceFactory;
import com.ru.vsu.csf.group7.filonov.service.Service;

import java.util.Optional;

@Injectable
public class BookPage extends Page {

    public BookPage() {
        Optional<Service> service = ServiceFactory.getINSTANCE().getService(TypeSubject.BOOK);
        if (service.isPresent())
            setService(service.get());
        else
            throw new NullPointerException("Not found service for BookPage");
    }

    @Override
    public String toString() {
        return "Book";
    }
}
