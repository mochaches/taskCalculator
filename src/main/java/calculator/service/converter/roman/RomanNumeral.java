package calculator.service.converter.roman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumeral {
    I(1, true),
    IV(4, false),
    V(5, false),
    IX(9, false),
    X(10, true),
    XL(40, false),
    L(50, false),
    XC(90, false),
    C(100, true);
//    CD(400, false),
//    D(500, false),
//    CM(900, false),
//    M(1000, true);

    private int value;
    private boolean repeatable;

    RomanNumeral(int value, boolean repeatable) {
        this.value = value;
        this.repeatable = repeatable;

    }

    public int getValue() {
        return value;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}

