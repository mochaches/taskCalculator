package calculator.service.converter;

import calculator.service.converter.roman.RomanConverterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanConverterServiceImplTest {

    private static final String IX = "IX";
    private static final String IV = "IV";
    private static final String VII = "VII";
    private static final String II = "II";
    private RomanConverterServiceImpl converter = new RomanConverterServiceImpl();

    @Test
    void getFromText() {
        int vii = converter.getFromText(VII);
        Assertions.assertEquals(7, vii);
        int iv = converter.getFromText(IV);
        Assertions.assertEquals(4, iv);
        int ix = converter.getFromText(IX);
        Assertions.assertEquals(9, ix);
        int ii = converter.getFromText(II);
        Assertions.assertEquals(2, ii);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            converter.getFromText("VV");
        });
    }

    @Test
    void getFromNumber() {
        String rom9 = converter.getFromNumber(9);
        Assertions.assertEquals(IX, rom9);
        String rom4 = converter.getFromNumber(4);
        Assertions.assertEquals(IV, rom4);
        String rom7 = converter.getFromNumber(7);
        Assertions.assertEquals(VII, rom7);
    }

    @Test
    void check() {
        boolean expectedTrue = converter.check(VII);
        Assertions.assertEquals(true, expectedTrue);
        boolean expectedFalse = converter.check("CKIIX");
        Assertions.assertEquals(false, expectedFalse);
    }
    @Test
    void repeatCheck() {
        boolean expectedTrue = converter.repeatCheck(VII);
        Assertions.assertEquals(true, expectedTrue);
        boolean expectedFalse = converter.repeatCheck("IIII");
        Assertions.assertEquals(false, expectedFalse);
    }


}