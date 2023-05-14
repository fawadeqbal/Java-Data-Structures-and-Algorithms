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

public class InfixToPostfix {
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char symbol : infix.toCharArray()) {
            if (Character.isLetterOrDigit(symbol)) {
                postfix.append(symbol);
            } else if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid expression"; // Unmatched parentheses
                } else {
                    stack.pop();
                }
            } else { // Operator
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(symbol)) {
                    postfix.append(stack.pop());
                }
                stack.push(symbol);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid expression"; // Unmatched parentheses
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
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

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix));
    }
}

