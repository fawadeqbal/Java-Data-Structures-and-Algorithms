package test;
import java.util.Scanner;
import stack.array.Stack;

public class InfixToPostfix {
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

    // Check if a string is a two-digit number
    static boolean isTwoDigitOperand(String str) {
        return str.length() == 2 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1));
    }

    // Convert infix expression to postfix expression
    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                StringBuilder operand = new StringBuilder();
                operand.append(ch);

                // Check if the next character is also a letter or digit
                while (i + 1 < infix.length() && Character.isLetterOrDigit(infix.charAt(i + 1))) {
                    operand.append(infix.charAt(i + 1));
                    i++;
                }

                postfix.append(operand.toString());
                postfix.append(" "); // Add a space separator
            } else if (ch == '(') {
                stack.push(Character.toString(ch));
            } else if (ch == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop());
                    postfix.append(" "); // Add a space separator
                }
                if (!stack.isEmpty() && !stack.peek().equals("(")) {
                    return "Invalid Expression"; // Unmatched right parenthesis
                } else {
                    stack.pop(); // Pop the left parenthesis
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek().charAt(0))) {
                    postfix.append(stack.pop());
                    postfix.append(" "); // Add a space separator
                }
                stack.push(Character.toString(ch));
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                return "Invalid Expression"; // Unmatched left parenthesis
            }
            postfix.append(stack.pop());
            postfix.append(" "); // Add a space separator
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>(postfix.length());

        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (isTwoDigitOperand(token)) {
                stack.push(Integer.parseInt(token));
            } else if (Character.isDigit(token.charAt(0))) {
                stack.push(token.charAt(0) - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.next();

        String postfix = infixToPostfix(infix);
        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);

        int result = evaluatePostfix(postfix);
        System.out.println("Result: " + result);
    }
}


