package com.ru.vsu.csf.group7.filonov.ui.console.input;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

public interface InputSubject {
    Subject input();
    TypeSubject getType();
}
