package com.ru.vsu.csf.group7.filonov.ui.console.input;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Journal;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.util.Scanner;

public class InputJournalConsole implements InputSubject {

    private TypeSubject type;
    private Scanner scanner;

    public InputJournalConsole(TypeSubject type, Scanner scanner) {
        this.type = type;
        this.scanner = scanner;
    }

    @Override
    public Subject input() {
        System.out.println("Введите название; уникальный номер; год, месяц и день выпуска; количество страниц; " +
                        "количество поступивших журналов");
        return new Journal(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
                scanner.nextInt(), scanner.nextInt());
    }

    public TypeSubject getType() {
        return type;
    }
}
