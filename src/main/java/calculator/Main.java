package calculator;

import calculator.core.OperationService;
import calculator.core.OperationServiceImpl;

public class Main {
    public static void main(String[] args) {
        OperationService operationService = new OperationServiceImpl();
        operationService.identification();
    }
}
