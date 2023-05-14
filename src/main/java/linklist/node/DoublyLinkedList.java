/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linklist.node;

/**
 *
 * @author fawad
 */
public class DoublyLinkedList {

    Node head; // head of the linked list

    // Node class
    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // Constructor to initialize the head of the linked list
    DoublyLinkedList() {
        head = null;
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count the number of nodes in the linked list
    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Find a node with a given key value
    public Node find(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a new node with given data at the beginning of the linked list
    public void addAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Add a new node with given data at the end of the linked list
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Add a new node with given data after the node with a given key value
    public void addAfter(int key, int data) {
        Node newNode = new Node(data);
        Node temp = find(key);
        if (temp == null) {
            System.out.println("Node with key " + key + " not found");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = newNode;
            newNode.next = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete the node with given data from the linked list
    public void delete(int key) {
        Node temp = find(key);
        if (temp == null) {
            System.out.println("Node with key " + key + " not found");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }
}
