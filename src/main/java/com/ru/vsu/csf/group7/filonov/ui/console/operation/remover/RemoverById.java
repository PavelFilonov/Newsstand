package com.ru.vsu.csf.group7.filonov.ui.console.operation.remover;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import com.ru.vsu.csf.group7.filonov.service.Service;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;
import com.ru.vsu.csf.group7.filonov.ui.console.operation.Operation;

@Injectable()
public class RemoverById implements Operation {

    @Override
    public void execute(Service service, UIManager uiManager) {
        uiManager.output().resultDeleting(
                service.remove(uiManager.input().getLongValue())
        );
    }

    @Override
    public String toString() {
        return "Удалить по id";
    }
}
