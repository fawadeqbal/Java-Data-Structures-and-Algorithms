/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.linklist;

/**
 *
 * @author fawad
 */
public class StackUsingLinkedList {

    private Node top;

    // Node class
    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Constructor to initialize an empty stack
    public StackUsingLinkedList() {
        top = null;
    }

    // Push an element to the top of the stack
    public void push(int element) {
        Node newNode = new Node(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Pop the top element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int element = top.data;
        top = top.next;
        return element;
    }

    // Peek the top element of the stack without removing it
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }// Check if the stack is empty

    public boolean isEmpty() {
        return top == null;
    }

// Display the elements of the stack
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        Node currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
