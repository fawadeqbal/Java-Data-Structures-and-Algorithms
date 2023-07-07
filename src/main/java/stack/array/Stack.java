package stack.array;

public class Stack<T> {
    private int maxSize;
    private Object[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new Object[maxSize];
        top = -1;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Push an item onto the stack
    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Cannot push item.");
        }
        stackArray[++top] = item;
    }

    // Pop an item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop item.");
        }
        return (T) stackArray[top--];
    }

    // Get the top item of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek item.");
        }
        return (T) stackArray[top];
    }
}
