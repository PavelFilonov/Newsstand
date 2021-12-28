package com.ru.vsu.csf.group7.filonov.ui.console;

import com.ru.vsu.csf.group7.filonov.factory.bean.BeanFactory;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.page.Page;

import java.util.InputMismatchException;
import java.util.List;

class MainMenu {

    private final UIManager uiManager;
    private List<Page> pages;

    MainMenu(UIManager uiManager) {
        this.uiManager = uiManager;
        pages = BeanFactory.getInstance().getBeans(Page.class);
    }

    void start() {
        while (true) {
            uiManager.output().outputChooserTable(pages);

            uiManager.output().outputMessage("Введите номер таблицы: ");
            int i;
            try {
                i = uiManager.input().getIntValue();
            } catch (InputMismatchException e) {
                uiManager.output().outputMessage("Неверный ввод");
                break;
            }

            if (i < 0 || i > pages.size()) {
                uiManager.output().outputMessage("Введено неверное число");
                continue;
            }

            if (i == pages.size()) {
                uiManager.output().outputMessage("Завершение программы...");
                break;
            }

            try {
                pages.get(i).open(uiManager);
            } catch (InputMismatchException e) {
                uiManager.output().outputMessage("Неверный ввод");
                break;
            }
        }
    }
}
