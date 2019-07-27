package calculator.service.converter;

/**
 * Преобразует строки в числа и обратно
 */
public interface ConverterService {

    /**
     * получить число из строки
     *
     * @param input исходный текст
     * @return число полученное из текста
     */
    int getFromText(String input);

    /**
     * получить строку из числа,
     *
     * @param number исходное число
     * @return текст
     */
    String getFromNumber(int number);

    /**
     * определить является ли текст
     * допустимым к конвертации этим конвертером
     *
     * @param source исходный текст
     * @return допустимость
     */
    boolean check(String source);
}
