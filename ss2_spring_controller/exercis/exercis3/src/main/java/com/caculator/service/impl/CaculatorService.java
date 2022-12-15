package com.caculator.service.impl;

import com.caculator.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {


    @Override
    public double caculator(double firstNumber, char operator, double secondNumber) {
        double result = 0;
        switch (operator){
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0){
                    throw new RuntimeException("Not divided by zero");
                }else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
        return result;
    }
}
