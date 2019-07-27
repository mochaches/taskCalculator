package calculator.service.converter.arab;

import calculator.exception.IncorrectCommandException;
import calculator.service.converter.ConverterService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerConverterServiceImpl implements ConverterService {

    @Override
    public boolean check(String source) {
        Pattern compile = Pattern.compile("\\d");
        Matcher arab = compile.matcher(source);

        Pattern compile2 = Pattern.compile("(\\d){2,}");
        Matcher arab2 = compile2.matcher(source);
        if (arab2.matches())  throw new IncorrectCommandException("превышен допустимый диапазон цифр(0-9)");

        return arab.matches();
    }

    @Override
    public int getFromText(String input) {
        return Integer.parseInt(input);
    }

    @Override
    public String getFromNumber(int number) {
        return String.valueOf(number);
    }
}
