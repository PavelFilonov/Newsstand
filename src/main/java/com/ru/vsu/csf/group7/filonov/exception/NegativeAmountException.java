package com.ru.vsu.csf.group7.filonov.exception;

public class NegativeAmountException extends Exception {

    public NegativeAmountException() {
        super("Отрицательное количество");
    }

    public NegativeAmountException(String message) {
        super(message);
    }
}
