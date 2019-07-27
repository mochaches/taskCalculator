package calculator.service.converter;

import calculator.service.converter.arab.IntegerConverterServiceImpl;
import calculator.service.converter.roman.RomanConverterServiceImpl;

import java.util.List;

public class UniversalConverterImpl implements UniversalConverter {

    private static List<ConverterService> converters = List.of(new IntegerConverterServiceImpl(), new RomanConverterServiceImpl());
    private ConverterService lastConverter;

    @Override
    public int[] getFromText(String textA, String textB) {
        int[] number = new int[2];
        for (ConverterService element : converters) {
            if (element.check(textA) && element.check(textB)) {
                number[0] = element.getFromText(textA);
                number[1] = element.getFromText(textB);
                lastConverter = element;
                break;
            }
        }
        return number;
    }

    @Override
    public String getFromNumber(int number) {
        return lastConverter.getFromNumber(number);
    }


}
