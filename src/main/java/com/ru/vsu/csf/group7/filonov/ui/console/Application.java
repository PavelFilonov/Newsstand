package com.ru.vsu.csf.group7.filonov.ui.console;

import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;

public class Application {

    private final UIManager uiManager;

    public Application(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    public void start() {
        if (uiManager != null)
            new MainMenu(uiManager).start();
    }
}
