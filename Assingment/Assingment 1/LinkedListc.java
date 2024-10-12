class LinkedListc {
    Node head; // Head of the list

    // Node class to define the structure of a linked list node
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to reverse the linked list
    public void reverse() {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            // Store the next node
            next = current.next;
            // Reverse the current node's pointer
            current.next = prev;
            // Move pointers one position ahead
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Utility function to add a new node at the end of the list
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
    }

    // Utility function to print the list
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    // Main method to test the reverse function
    public static void main(String[] args) {
        LinkedListc list = new LinkedListc();
        list.append(50);
        list.append(40);
        list.append(30);
        list.append(20);
        list.append(10);

        System.out.println("Original list:");
        list.printList();

        list.reverse();

        System.out.println("Reversed list:");
        list.printList();
    }
}
