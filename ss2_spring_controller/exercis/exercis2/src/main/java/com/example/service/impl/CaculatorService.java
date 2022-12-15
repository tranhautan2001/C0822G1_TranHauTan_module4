package com.example.service.impl;

import org.springframework.stereotype.Service;
import com.example.service.ICaculatorService;
@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public double caculator(Double fristNumber, char caculations, Double secondNumber) {
        double result = 0;
        switch (caculations){
            case '+':
                result = fristNumber + secondNumber;
                break;
            case '-':
                result = fristNumber - secondNumber;
                break;
            case '*':
                result = fristNumber + secondNumber;
                break;
            case '/':
                if (secondNumber == 0){
                    throw new RuntimeException("Not divided by zero");
                }else {
                    result = fristNumber / secondNumber;
                }
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
        return result;
    }

}
