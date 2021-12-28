package com.ru.vsu.csf.group7.filonov.ui.console.operation.replacer;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.exception.NegativeAmountException;
import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;

@Injectable()
public class Replacer implements Operation {

    @Override
    public void execute(Service service, UIManager uiManager) {
        try {
            uiManager.output().resultUpdating(
                    service.replace(uiManager.input().getLongValue(), uiManager.input().getSubject(service.getType()))
            );
        } catch (NegativeAmountException e) {
            uiManager.output().outputMessage(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Обновить";
    }
}
