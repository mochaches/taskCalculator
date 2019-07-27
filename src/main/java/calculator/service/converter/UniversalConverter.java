package calculator.service.converter;

public interface UniversalConverter {

    int[] getFromText(String textA, String textB);

    String getFromNumber(int number);
}
