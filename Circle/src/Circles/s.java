package Circles;

import java.util.Scanner;

// Custom generic queue implementation
class G<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> front;
    private Node<T> rear;

    public G() {
        front = null;
        rear = null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Car wash service
public class s {
    private G<String> carQueue;

    public s() {
        carQueue = new G<>();
    }

    // Car arrives at the car wash and joins the queue
    public void arriveAtCarWash(String car) {
        carQueue.enqueue(car);
        System.out.println(car + " has arrived at the car wash and joined the queue.");
    }

    // Car wash completes for the next car in the queue
    public void carWashCompleted() {
        if (!carQueue.isEmpty()) {
            String car = carQueue.dequeue();
            System.out.println(car + " has completed the car wash.");
        } else {
            System.out.println("No cars in the queue.");
        }
    }

    // Check if the car queue is empty
    public boolean isEmpty() {
        return carQueue.isEmpty();
    }

    // Get the size of the car queue
    public int queueSize() {
        return carQueue.size();
    }

    // Display the cars currently in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No cars in the queue.");
        } else {
            System.out.println("Cars currently in the queue:");
            G.Node<String> current = carQueue.front;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        s carWash = new s();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Arrive at Car Wash");
            System.out.println("2. Car Wash Completed");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter car name: ");
                    String carName = scanner.nextLine();
                    carWash.arriveAtCarWash(carName);
                    break;
                case 2:
                    carWash.carWashCompleted();
                    break;
                case 3:
                    carWash.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}