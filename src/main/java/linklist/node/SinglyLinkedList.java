/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linklist.node;

/**
 *
 * @author fawad
 */
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class SinglyLinkedList {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int value) {
        Node n = new Node(value);
        if (isEmpty()) {
            head = n;
            size++;
        } else {
            n.next = head;
            head = n;
            size++;
        }
    }

    public void addAtEnd(int value) {
        Node n = new Node(value);
        if (isEmpty()) {
            head = n;
            size++;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
            size++;
        }
    }

    public void addAfter(int key, int value) {
        Node n = new Node(value);
        Node p = find(key);
        if (p == null) {
            System.out.println("Node with key " + key + " not found");
            return;
        }
        n.next = p.next;
        p.next = n;
        size++;

    }

    public void delete(int key) {
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next; // Change the head node
            size--;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;

        }

        if (temp == null) {
            System.out.println("Key is not found.");
            return;
        }
        prev.next = temp.next;
        size--;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }
    public void display() {

        if (isEmpty()) {
            System.out.println("List is Empty.");
        } else {
            Node n = head;
            while (n != null) {
                System.out.print(n.data + "\t");
                n = n.next;
            }
            System.out.println("");
        }
    }

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

    public static void main(String[] args) {
        SinglyLinkedList n = new SinglyLinkedList();
        n.addFirst(12);
        n.addAtEnd(20);
        n.addAfter(12, 18);
        System.out.println(n.size());
        n.display();
        n.delete(18);
        n.display();
        System.out.println(n.size());

    }

}
