package calculator.exception;

/**
 * Введена неправильная команда
 */
public class IncorrectCommandException extends RuntimeException {

    /**
     * Сообщение об ошибке
     */
    public IncorrectCommandException(String message) {
        super(message);
    }
}
