package com.serenitydojo.calculator;

import java.util.Stack;

public class Calculator {

    public int evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return 0;
        }

        String[] tokens = expression.split(" ");
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    int secondOperand = numbers.pop();
                    int firstOperand = numbers.pop();
                    String operator = operators.pop();
                    numbers.push(applyOperator(firstOperand, secondOperand, operator));
                }
                operators.push(token);
            } else {
                throw new IllegalMathOperatorException("Unsupported operator: " + token);
            }
        }

        while (!operators.isEmpty()) {
            int secondOperand = numbers.pop();
            int firstOperand = numbers.pop();
            String operator = operators.pop();
            numbers.push(applyOperator(firstOperand, secondOperand, operator));
        }

        return numbers.pop();
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token);
    }

    private int precedence(String operator) {
        switch (operator) {
            case "*":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    private int applyOperator(int firstOperand, int secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}



