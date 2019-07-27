package calculator.service;

import calculator.utils.ArithmeticOperation;

public interface ProcessOperationService {

    int calculate(int one, int two, ArithmeticOperation operation);
}
