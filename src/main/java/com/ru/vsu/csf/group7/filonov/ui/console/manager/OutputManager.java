package com.ru.vsu.csf.group7.filonov.ui.console.manager;

import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;
import com.ru.vsu.csf.group7.filonov.ui.console.page.Page;

import java.util.List;

public interface OutputManager {

    void outputSubject(Subject subject);
    void outputSubjects(List<Subject> subjects);
    void resultInsertion(boolean added);
    void resultDeleting(boolean deleted);
    void resultUpdating(boolean updated);
    void outputMessage(String message);
    void outputChooserTable(List<Page> pages);
    void outputChooserOperation(List<Operation> operations);

}
