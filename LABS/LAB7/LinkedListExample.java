class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to add a new node at the end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Iterative approach to print all nodes
    public void printIterative() {
        Node current = head;
        System.out.print("Iterative: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Recursive approach to print all nodes
    public void printRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printRecursive(node.next);
    }

    public void printRecursive() {
        System.out.print("Recursive: ");
        printRecursive(head);
        System.out.println();
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding nodes to the linked list
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // Time and print using iterative approach
        long startTimeIterative = System.nanoTime();
        list.printIterative();
        long endTimeIterative = System.nanoTime();
        long durationIterative = endTimeIterative - startTimeIterative;

        // Time and print using recursive approach
        long startTimeRecursive = System.nanoTime();
        list.printRecursive();
        long endTimeRecursive = System.nanoTime();
        long durationRecursive = endTimeRecursive - startTimeRecursive;

        // Display time taken by each method
        System.out.println("Time taken by Iterative approach: " + durationIterative + " nanoseconds");
        System.out.println("Time taken by Recursive approach: " + durationRecursive + " nanoseconds");

        // Compare time
        if (durationIterative < durationRecursive) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }
    }
}
