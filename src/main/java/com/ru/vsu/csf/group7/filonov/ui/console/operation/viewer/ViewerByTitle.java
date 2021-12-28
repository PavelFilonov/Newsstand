package com.ru.vsu.csf.group7.filonov.ui.console.operation.viewer;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;

@Injectable
public class ViewerByTitle implements Operation {

    @Override
    public void execute(Service service, UIManager uiManager) {
        uiManager.output().outputSubjects(
                service.get(uiManager.input().getStringValue())
        );
    }

    @Override
    public String toString() {
        return "Вывести по названию";
    }
}
