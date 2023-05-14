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

public class PostfixEvaluation {
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char symbol : postfix.toCharArray()) {
            if (Character.isDigit(symbol)) {
                stack.push(symbol - '0');
            } else { // Operator
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (symbol) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
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
        String postfix = "23+4*5-";
        System.out.println("Postfix: " + postfix);
        System.out.println("Result: " + evaluatePostfix(postfix));
    }
}

