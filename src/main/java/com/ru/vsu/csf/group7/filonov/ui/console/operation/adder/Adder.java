package com.ru.vsu.csf.group7.filonov.ui.console.operation.adder;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.exception.NegativeAmountException;
import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;

@Injectable()
public class Adder implements Operation {

    @Override
    public void execute(Service service, UIManager uiManager) {
        try {
            uiManager.output().resultInsertion(
                    service.add(uiManager.input().getSubject(service.getType()))
            );
        } catch (NegativeAmountException e) {
            uiManager.output().outputMessage(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Добавить";
    }
}
