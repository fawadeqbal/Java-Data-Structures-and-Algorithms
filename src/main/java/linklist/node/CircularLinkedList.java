/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linklist.node;

/**
 *
 * @author fawad
 */
public class CircularLinkedList {

    Node last; // last node of the circular linked list

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Constructor to initialize the last node of the circular linked list
    CircularLinkedList() {
        last = null;
    }

    // Display the circular linked list
    public void display() {
        if (last == null) {
            System.out.println("Circular linked list is empty");
            return;
        }
        Node temp = last.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }

    // Count the number of nodes in the circular linked list
    public int countNodes() {
        int count = 0;
        if (last == null) {
            return count;
        }
        Node temp = last.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);
        return count;
    }

    // Find a node with a given key value
    public Node find(int key) {
        if (last == null) {
            return null;
        }
        Node temp = last.next;
        do {
            if (temp.data == key) {
                return temp;
            }
            temp = temp.next;
        } while (temp != last.next);
        return null;
    }

    // Add a new node with given data at the beginning of the circular linked list
    public void addAtFirst(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    // Add a new node with given data at the end of the circular linked list
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    // Add a new node with given data after the node with a given key value
    public void addAfter(int key, int data) {
        Node newNode = new Node(data);
        if (last == null) {
            System.out.println("Circular linked list is empty");
            return;
        }
        Node temp = find(key);
        if (temp == null) {
            System.out.println("Node with key " + key + " not found");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == last) {
            last = newNode;
        }
    }

    // Delete the node with given data from the circular linked list
    public void delete(int key) {
        if (last == null) {
            System.out.println("Circular linked list is empty");
            return;
        }
        Node temp = last.next;
        Node prev = last;
        do {
            if (temp.data == key) {
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != last.next);
        if (temp == last.next && temp == last) {
            last = null;
        } else if (temp == last.next) {
            last.next = temp.next;
        } else if (temp == last) {
            prev.next = last.next;

            last = prev;
        } else {
            prev.next = temp.next;
        }
    }
}
