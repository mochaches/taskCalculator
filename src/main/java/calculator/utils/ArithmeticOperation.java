package calculator.utils;

import java.util.HashMap;
import java.util.Map;

public enum ArithmeticOperation {

    ADDITION("+"),
    SUBTRACTION("-"),
    DIVISION("/"),
    MULTIPLE("*");

    String operation;

    private static final Map<String, ArithmeticOperation> map = new HashMap<>();

    static {
        for (ArithmeticOperation v : ArithmeticOperation.values()) {
            map.put(v.operation, v);
        }
    }

    ArithmeticOperation(String operation) {
        this.operation = operation;
    }

    public static ArithmeticOperation getFromString(String operation) {
        return map.get(operation);
    }
}
