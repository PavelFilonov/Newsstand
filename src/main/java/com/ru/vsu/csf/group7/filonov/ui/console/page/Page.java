package com.ru.vsu.csf.group7.filonov.ui.console.page;

import com.ru.vsu.csf.group7.filonov.factory.bean.BeanFactory;
import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;

import java.util.InputMismatchException;
import java.util.List;

public abstract class Page {

    private Service service;
    private List<Operation> operations;

    Page() {
        operations = BeanFactory.getInstance().getBeans(Operation.class);
    }

    public void open(UIManager uiManager) {
        uiManager.output().outputChooserOperation(operations);

        int i;
        try {
            i = uiManager.input().getIntValue();
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }

        if (i < 0 || i > operations.size()) {
            uiManager.output().outputMessage("Введено неверное число");
            return;
        }

        if (i == operations.size())
            return;

        operations.get(i).execute(service, uiManager);
    }

    protected void setService(Service service) {
        this.service = service;
    }
}
