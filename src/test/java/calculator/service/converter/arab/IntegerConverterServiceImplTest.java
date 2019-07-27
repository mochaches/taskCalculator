package calculator.service.converter.arab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerConverterServiceImplTest {

    private IntegerConverterServiceImpl converter = new IntegerConverterServiceImpl();

    @Test
    void check() {
       boolean expectedTrue = converter.check("5");
        Assertions.assertEquals(true, expectedTrue);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            converter.check("sd0");
        });
    }

    @Test
    void getFromText() {
        int seven = converter.getFromText("7");
        Assertions.assertEquals(7, seven);
        int six = converter.getFromText("6");
        Assertions.assertEquals(6, six);
    }

    @Test
    void getFromNumber() {
    }
}