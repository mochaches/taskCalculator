package calculator.core;

import calculator.exception.IncorrectCommandException;
import calculator.service.ProcessOperationService;
import calculator.service.TerminalService;
import calculator.service.converter.UniversalConverter;
import calculator.service.converter.UniversalConverterImpl;
import calculator.service.impl.ConsoleTerminalServiceImpl;
import calculator.service.impl.ProcessOperationServiceImpl;
import calculator.utils.ArithmeticOperation;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class OperationServiceImpl implements OperationService {

    private static final String ERROR_MESSAGE = "команда введена некорректно";
    private static final String UNKNOWN_SYMBOL = "неизвестный арифметический знак";

    @Override
    public void identification(){
        TerminalService terminal = new ConsoleTerminalServiceImpl();
        UniversalConverter universalConverter = new UniversalConverterImpl();
        ProcessOperationService processOperationService = new ProcessOperationServiceImpl();

        String command = terminal.get();

        String[] text = command.split(StringUtils.SPACE);
        if (text.length != 3) {
            throw new IncorrectCommandException(MessageFormat.format("{0}: {1}", ERROR_MESSAGE, command));
        }

        ArithmeticOperation arithmeticOperation = ArithmeticOperation.getFromString(text[1]);
        if (arithmeticOperation == null) {
            throw new IncorrectCommandException(MessageFormat.format("{0}: {1}", UNKNOWN_SYMBOL, command));
        }
        int[] enterNumber = universalConverter.getFromText(text[0], text[2]);

        int calculate = processOperationService.calculate(enterNumber[0], enterNumber[1], arithmeticOperation);

        String result = universalConverter.getFromNumber(calculate);

        terminal.send(result);

    }
}
