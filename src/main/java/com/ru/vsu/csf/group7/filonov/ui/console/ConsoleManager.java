package com.ru.vsu.csf.group7.filonov.ui.console;

import com.ru.vsu.csf.group7.filonov.ui.console.input.InputManagerConsole;
import com.ru.vsu.csf.group7.filonov.ui.console.output.OutputManagerConsole;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.InputManager;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.OutputManager;
import com.ru.vsu.csf.group7.filonov.ui.console.manager.UIManager;

import java.util.Scanner;

public class ConsoleManager implements UIManager {

    private final Scanner scanner;
    private final InputManager im;
    private final OutputManager om;

    public ConsoleManager(Scanner scanner) {
        this.scanner = scanner;
        im = new InputManagerConsole(scanner);
        om = new OutputManagerConsole();
    }

    public ConsoleManager() {
        scanner = new Scanner(System.in);
        im = new InputManagerConsole(scanner);
        om = new OutputManagerConsole();
    }

    public InputManager input() {
        return im;
    }

    public OutputManager output() {
        return om;
    }
}
