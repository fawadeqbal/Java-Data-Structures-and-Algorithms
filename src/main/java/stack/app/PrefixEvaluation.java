/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.app;

/**
 *
 * @author fawad
 */
import java.util.*;

public class PrefixEvaluation {
    public static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder reversedPrefix = new StringBuilder(prefix).reverse();

        for (char symbol : reversedPrefix.toString().toCharArray()) {
            if (Character.isDigit(symbol)) {
                stack.push(symbol - '0');
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = performOperation(symbol, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String prefix = "*+23-45";
        System.out.println("Prefix: " + prefix);
        System.out.println("Result: " + evaluatePrefix(prefix));
    }
}

