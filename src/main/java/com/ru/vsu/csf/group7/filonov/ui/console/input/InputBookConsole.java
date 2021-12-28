package com.ru.vsu.csf.group7.filonov.ui.console.input;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Book;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.util.Scanner;

public class InputBookConsole implements InputSubject {

    private TypeSubject type;
    private Scanner scanner;

    public InputBookConsole(TypeSubject type, Scanner scanner) {
        this.type = type;
        this.scanner = scanner;
    }

    @Override
    public Subject input() {
        System.out.println("Введите название; автора; издателя; количество страниц; количество поступивших книг");
        return new Book(scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt());
    }

    public TypeSubject getType() {
        return type;
    }
}
