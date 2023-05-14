/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.array;

/**
 *
 * @author fawad
 */
public class StackUsingArray {

    private int[] arr;
    private int top;
    private int capacity;

    // Constructor to initialize stack with given capacity
    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    // Push an element to the top of the stack
    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        arr[top] = element;
    }

    // Pop the top element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        int element = arr[top];
        top--;
        return element;
    }

    // Peek the top element of the stack without removing it
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display the elements of the stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
