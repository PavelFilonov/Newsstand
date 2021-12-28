package com.ru.vsu.csf.group7.filonov.ui.console.operation.viewer;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;

@Injectable
public class ViewerById implements Operation {

    @Override
    public void execute(Service service, UIManager uiManager) {
        uiManager.output().outputSubject(
                service.get(uiManager.input().getLongValue()).orElse(null)
        );
    }

    @Override
    public String toString() {
        return "Вывести по id";
    }
}
