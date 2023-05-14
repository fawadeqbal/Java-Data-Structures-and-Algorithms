/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linklist.node;

/**
 *
 * @author fawad
 */
public class SinglyLinkedList {

    Node head; // head of the linked list

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
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
        newNode.next = head;
        head = newNode;
    }

    // Add a new node with given data at the end of the linked list
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add a new node with given data after the node with a given key value
    public void addAfter(int key, int data) {
        Node newNode = new Node(data);
        Node temp = find(key);
        if (temp == null) {
            System.out.println("Node with key " + key + " not found");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete the last node in the linked list
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void delete(int key) {
        Node temp = head;
        Node prev = null;

        // If the head node itself contains the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Change the head node
            return;
        }

        // Search for the key to be deleted, keep track of the previous node as well
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in the linked list
        if (temp == null) {
            return;
        }

        // Unlink the node from the linked list
        prev.next = temp.next;
    }

}
