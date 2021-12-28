package com.ru.vsu.csf.group7.filonov.ui.console.input;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Newspaper;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import java.util.Scanner;

public class InputNewspaperConsole implements InputSubject {

    private TypeSubject type;
    private Scanner scanner;

    public InputNewspaperConsole(TypeSubject type, Scanner scanner) {
        this.type = type;
        this.scanner = scanner;
    }

    @Override
    public Subject input() {
        System.out.println("Введите название; уникальный номер; год, месяц и день выпуска; количество поступивших газет");
        return new Newspaper(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
                scanner.nextInt());
    }

    public TypeSubject getType() {
        return type;
    }
}
