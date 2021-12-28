package com.ru.vsu.csf.group7.filonov.ui.console.output;

import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.OutputManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;
import com.ru.vsu.csf.group7.filonov.ui.console.page.Page;

import java.util.List;

public class OutputManagerConsole implements OutputManager {

    @Override
    public void outputSubject(Subject subject) {
        if (subject != null)
            System.out.println(subject.toString() + "\n");
        else
            System.out.println("Нет данных\n");
    }

    @Override
    public void outputSubjects(List<Subject> subjects) {
        if (subjects.isEmpty())
            System.out.println("Нет данных\n");
        for (Subject s: subjects) {
            System.out.println(s.toString());
        }
        System.out.println("\n");
    }

    @Override
    public void resultInsertion(boolean added) {
        if (added)
            System.out.println("Данные успешно добавлены\n");
        else
            System.out.println("Данные не добавлены\n");
    }

    @Override
    public void resultDeleting(boolean deleted) {
        if (deleted)
            System.out.println("Данные успешно удалены\n");
        else
            System.out.println("Данные не удалены\n");
    }

    @Override
    public void resultUpdating(boolean updated) {
        if (updated)
            System.out.println("Данные успешно обновлены\n");
        else
            System.out.println("Данные не обновлены\n");
    }

    @Override
    public void outputMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void outputChooserTable(List<Page> pages) {
        for (int i = 0; i < pages.size(); i++) {
            System.out.println(String.format("%d - %s", i, pages.get(i).toString()));
        }
        System.out.println(String.format("%d - выйти", pages.size()));
    }

    @Override
    public void outputChooserOperation(List<Operation> operations) {
        for (int i = 0; i < operations.size(); i++) {
            System.out.println(String.format("%d - %s", i, operations.get(i)));
        }
        System.out.println(String.format("%d - назад", operations.size()));
    }


}
