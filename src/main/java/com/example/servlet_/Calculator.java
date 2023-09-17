package com.example.servlet_;

public class Calculator {
    float result;
    public Calculator(){

    }
    public float tinh(float number1, float number2 , String calculation) {
        switch (calculation){
            case "summation" :
                result = number1+number2;
                break;
            case "subtraction" :
                result = number1-number2;
                break;
            case "multiplication" :
                result = number1 * number2;
                break;
            case "division" :
                result = number1 / number2;
        }
        return result;
    }
}
