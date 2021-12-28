package com.ru.vsu.csf.group7.filonov.ui.console.manager;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

public interface InputManager {

    int getIntValue();
    Long getLongValue();
    String getStringValue();
    Subject getSubject(TypeSubject type);

}
