// Node class for DoubleLinkedList with tail
class DoubleNode {
    String name;
    DoubleNode prev, next;

    DoubleNode(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

public class DoubleLinkedListWithTail {
    DoubleNode head, tail;

    // Constructor
    public DoubleLinkedListWithTail() {
        head = null;
        tail = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(String name) {
        DoubleNode newNode = new DoubleNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(String name) {
        DoubleNode newNode = new DoubleNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Remove from the beginning
    public void removeFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Remove from the end
    public void removeFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Print all nodes
    public void printAll() {
        DoubleNode temp = head;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedListWithTail list = new DoubleLinkedListWithTail();
        
        // Testing insertions
        list.insertAtBeginning("Node1");
        list.insertAtBeginning("Node0");
        list.insertAtEnd("Node2");
        list.insertAtEnd("Node3");
        list.printAll(); // Expected: Node0 Node1 Node2 Node3
        
        // Testing removals
        list.removeFromBeginning();
        list.printAll(); // Expected: Node1 Node2 Node3
        list.removeFromEnd();
        list.printAll(); // Expected: Node1 Node2
    }
}
