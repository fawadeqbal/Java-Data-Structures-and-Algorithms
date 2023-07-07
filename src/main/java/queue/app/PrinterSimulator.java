package queue.app;

import java.util.Scanner;

class Node {

    int jobNumber;
    int numOfPages;
    Node next;

    public Node(int jobNumber,int numOfPages) {
        this.jobNumber = jobNumber;
        this.numOfPages = numOfPages;
        this.next = null;
    }
}

class Queue {

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void enqueue(int numOfPages) {
        size++;
        Node newNode = new Node(size, numOfPages);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node dequeuedNode = front;
            front = front.next;
            size--;
            if (front == null) {
                rear = null;
            }
            return dequeuedNode;
        }
    }

    public int size() {
        return this.size;
    }
}

public class PrinterSimulator {

    public static void main(String[] args) {
        Queue printingQueue = new Queue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Printer Simulator");
            System.out.println("1. Add printing job");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of printing jobs: ");
                    int numOfJobs = scanner.nextInt();

                    for (int i = 1; i <= numOfJobs; i++) {
                        System.out.printf("Enter the number of pages per job %d: ", i);
                        int numOfPages = scanner.nextInt();
                        printingQueue.enqueue(numOfPages);
                    }
                    System.out.println("Printing jobs added to the queue.");
                    while(!printingQueue.isEmpty()){
                     if (printingQueue.isEmpty()) {
                        System.out.println("No jobs in the queue.");
                    } else {
                        Node job = printingQueue.dequeue();
                        System.out.println("Printing job " + job.jobNumber
                                + " with " + job.numOfPages + " pages...");
                        simulatePrinting(job.numOfPages);
                        System.out.println("Printing job " + job.jobNumber
                                + " completed. " + job.numOfPages + " pages printed.");
                    }}
                    System.out.println("Jobs printed.");
                    break;
                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void simulatePrinting(int numOfPages) {
        try {
            Thread.sleep(numOfPages * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
