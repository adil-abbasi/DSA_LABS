// Node class for the DoubleLinkedLista
class Node {
    String name;
    Node prev, next;

    Node(String name) {
        this.prev = null;
        this.next = null;
        this.name = name;
    }
}

// DoubleLinkedLista class with all required methods
public class DoubleLinkedLista {
    Node head;

    // Add node with name at the beginning of the linked list (name as parameter)
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        insertAtBeginning(newNode);
    }

    // Add node at the beginning of the linked list (node as parameter)
    public void insertAtBeginning(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Add node with name at the end of the linked list (name as parameter)
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        insertAtEnd(newNode);
    }

    // Add node at the end of the linked list (node as parameter)
    public void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    // Add node after a node with the given name (name and node as parameters)
    public void insertAfterName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp == null) {
            throw new IllegalArgumentException("Node with name " + name + " not found.");
        }
        node.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = node;
        }
        temp.next = node;
        node.prev = temp;
    }

    // Add node before a node with the given name (name and node as parameters)
    public void insertBeforeName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp == null) {
            throw new IllegalArgumentException("Node with name " + name + " not found.");
        }
        node.prev = temp.prev;
        node.next = temp;
        if (temp.prev != null) {
            temp.prev.next = node;
        } else {
            head = node;
        }
        temp.prev = node;
    }

    // Make the double linked list circular
    public void makeCircular() {
        if (head == null) return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;
    }

    // Print all nodes in the linked list (works on both regular and circular linked list)
    public void printAll() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.name + " ");
            temp = temp.next;
        } while (temp != null && temp != head); // Condition for circular linked list
        System.out.println();
    
    }

    // Test the class
    public static void main(String[] args) {
        DoubleLinkedLista list = new DoubleLinkedLista();

        // Test insert at the beginning
        list.insertAtBeginning("Node1");
        list.insertAtBeginning("Node0");
        list.printAll(); // Expected: Node0 Node1

        // Test insert at the end
        list.insertAtEnd("Node2");
        list.insertAtEnd("Node3");
        list.printAll(); // Expected: Node0 Node1 Node2 Node

    }}