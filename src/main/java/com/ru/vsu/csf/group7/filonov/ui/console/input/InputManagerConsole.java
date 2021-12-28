package com.ru.vsu.csf.group7.filonov.ui.console.input;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.InputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputManagerConsole implements InputManager {

    private final Scanner scanner;
    private final List<InputSubject> inputs;

    public InputManagerConsole(Scanner scanner) {
        this.scanner = scanner;
        inputs = new ArrayList<>();
        initInputs();
    }

    private void initInputs() {
        inputs.add(new InputBookConsole(TypeSubject.BOOK, scanner));
        inputs.add(new InputJournalConsole(TypeSubject.JOURNAL, scanner));
        inputs.add(new InputNewspaperConsole(TypeSubject.NEWSPAPER, scanner));
    }

    @Override
    public int getIntValue() {
        return scanner.nextInt();
    }

    @Override
    public Long getLongValue() {
        System.out.println("Введите id");
        return scanner.nextLong();
    }

    @Override
    public String getStringValue() {
        System.out.println("Введите название");
        return scanner.next();
    }

    @Override
    public Subject getSubject(TypeSubject type) {
        Optional<InputSubject> in = inputs.stream()
                .filter(input -> input.getType().equals(type))
                .findFirst();
        return in.map(InputSubject::input).orElse(null);
    }
}
