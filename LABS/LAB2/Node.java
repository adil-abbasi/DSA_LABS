public class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to add a node to the back of the list
    void addToBack(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    // Method to print the list
    void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Method to add a node to the front of the list
    void addToFront(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    // Method to add a node in the middle at a specific index
    void addMiddle(int index, int data) {
        Node node = new Node(data);
        if (index == 1) {
            addToFront(data);
            return;
        }

        Node n = head;
        for (int i = 1; i < index - 1 && n != null; i++) {
            n = n.next;
        }

        if (n != null) {
            node.next = n.next;
            n.next = node;
        }
    }

    // Method to remove a node from the front of the list
    void removeFromFront() {
        if (head != null) {
            head = head.next;
        }
    }

    // Method to remove a node from the back of the list
    void removeFromBack() {
        if (head == null || head.next == null) {
            head = null;
        } else {
            Node n = head;
            while (n.next.next != null) {
                n = n.next;
            }
            n.next = null;
        }
    }

    // Method to remove a node at a specific index
    void removeAt(int index) {
        if (index == 1) {
            removeFromFront();
        } else {
            Node n = head;
            for (int i = 1; i < index - 1 && n.next != null; i++) {
                n = n.next;
            }

            if (n.next != null) {
                n.next = n.next.next;
            }
        }
    }

    // Method to check if the list is empty
    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addToBack(5);
        ll.addToBack(19);

        ll.addToBack(19);
        ll.printList(); // Output: 5 19 19

        ll.addToFront(20);
        ll.printList(); // Output: 20 5 19 19

        ll.addMiddle(2, 200);
        ll.printList(); // Output: 20 200 5 19 19
    }
}
