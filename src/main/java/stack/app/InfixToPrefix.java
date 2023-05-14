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

public class InfixToPrefix {
    public static String infixToPrefix(String infix) {
        StringBuilder reversedInfix = new StringBuilder(infix).reverse();
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char symbol : reversedInfix.toString().toCharArray()) {
            if (Character.isLetterOrDigit(symbol)) {
                prefix.append(symbol);
            } else if (symbol == ')') {
                stack.push(symbol);
            } else if (symbol == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop the matching ')'
                }
            } else { // Operator
                while (!stack.isEmpty() && getPrecedence(stack.peek()) > getPrecedence(symbol)) {
                    prefix.append(stack.pop());
                }
                stack.push(getReversedOperator(symbol));
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static char getReversedOperator(char operator) {
        switch (operator) {
            case '+':
                return '-';
            case '-':
                return '+';
            case '*':
                return '/';
            case '/':
                return '*';
            case '^':
                return '^';
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String infix = "(A+B)*C-(D-E)*(F+G)";
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}

