package calculator.service.impl;

import calculator.service.TerminalService;

import java.util.Scanner;

/**
 * работа с консолью
 */
public class ConsoleTerminalServiceImpl implements TerminalService {

    @Override
    public void send(String source) {
        System.out.println(source);
    }

    @Override
    public String get() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        scanner.close();
        return result;
    }
}
