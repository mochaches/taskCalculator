package calculator.service;

/**
 * взаимодействие с внешним миром
 */
public interface TerminalService {

    /**
     * отправить строку
     *
     * @param source строку
     */
    void send(String source);

    /**
     * получить строку
     *
     * @return полученная строка
     */
    String get();
}
