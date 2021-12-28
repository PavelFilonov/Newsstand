package com.ru.vsu.csf.group7.filonov.ui.console.operation;

import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;

public interface Operation {
    void execute(Service service, UIManager uiManager);
}
