package calculator.service.impl;

import calculator.service.ProcessOperationService;
import calculator.utils.ArithmeticOperation;

public class ProcessOperationServiceImpl implements ProcessOperationService {

    @Override
    public int calculate(int one, int two, ArithmeticOperation operation) {
        return switch (operation) {
            case ADDITION -> one + two;
            case DIVISION -> one / two;
            case MULTIPLE -> one * two;
            case SUBTRACTION -> one - two;
        };
    }
}