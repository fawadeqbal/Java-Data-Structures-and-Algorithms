/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.array;

/**
 *
 * @author fawad
 */
public class Stack {

    private int[] data;
    private int top;

    public Stack(int size) {
        this.data = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is in Overflow Condition.");
        } else {
            data[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is in underflow Condition");
        } else {
            return data[top--];
        }

    }

    public int peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            throw new RuntimeException("Stack is in underflow Condition");
        }
    }
}
