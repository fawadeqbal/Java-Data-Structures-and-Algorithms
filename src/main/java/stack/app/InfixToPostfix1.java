/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.app;

/**
 *
 * @author fawad
 */


import stack.array.Stack;

public class InfixToPostfix1 {
    // Function to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Convert infix expression to postfix expression
    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>(30);

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // Unmatched right parenthesis
                } else {
                    stack.pop(); // Pop the left parenthesis
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Unmatched left parenthesis
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix) {
    Stack<Integer> stack = new Stack<>(30);

    for (char symbol : postfix.toCharArray()) {
        if (Character.isDigit(symbol)) {
            stack.push(symbol - '0');
        } else {
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            switch (symbol) {
                case '+':
                    stack.push(operand1 + operand2);
                    break;
                case '-':
                    stack.push(operand1 - operand2);  // Reversed order of operands
                    break;
                case '*':
                    stack.push(operand1 * operand2);
                    break;
                case '/':
                    stack.push(operand1 / operand2);  // Reversed order of operands
                    break;
                case '^':
                    stack.push((int) Math.pow(operand1, operand2));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + symbol);
            }
        }
    }

    return stack.pop();
}


    public static void main(String[] args) {
        String infix = "2+5*(4^2-16)-4";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);

        int result = evaluatePostfix(postfix);
        System.out.println("Result: " + result);
    }
}

