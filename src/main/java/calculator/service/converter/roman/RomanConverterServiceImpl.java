package calculator.service.converter.roman;

import calculator.exception.IncorrectCommandException;
import calculator.service.converter.ConverterService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanConverterServiceImpl implements ConverterService {

    public static final int MAX_ROMAN_NUMBER = 4000;

    @Override
    public int getFromText(String input) {
//        String inputNumeral = input.toUpperCase();
        String inputNumeral = input;
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        while ((inputNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (inputNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                inputNumeral = inputNumeral.substring(symbol.name().length());
                i = getNextUnrepeatable(romanNumerals, i);
            } else {
                i++;
            }
        }
        if (inputNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " строка введена некорректно!");
        }

        return result;

    }

    @Override
    public String getFromNumber(int number) {
        if ((number <= 0) || (number > MAX_ROMAN_NUMBER)) {
            throw new IllegalArgumentException(number + " превышен диапазон значений");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder convertToText = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                convertToText.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return convertToText.toString();
    }

    @Override
    public boolean check(String source) {

        final Pattern roman = Pattern.compile("([I]{1,3}|[I][VX]|[V][I]{0,3})");

        Matcher mRom = roman.matcher(source);

        if (!mRom.matches())  throw new IncorrectCommandException("строка введена некорректно");
        return true;
    }

    private int getNextUnrepeatable(List<RomanNumeral> list, int index) {
        if (list.get(index).isRepeatable()) {
            return index;
        }
        return ++index;
    }


    public boolean repeatCheck(String source) {
        char[] word = source.toCharArray();
        if (source.length() > 3) {
            for (int i = 0; i < word.length - 2; i++) {
                if (word[i] == word[i + 1] && word[i] == word[i + 2] && word[i] == word[i + 3]) return false;
            }
        }
        return true;
    }

}