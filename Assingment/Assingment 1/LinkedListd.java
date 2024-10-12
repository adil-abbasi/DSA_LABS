import java.util.HashSet;

class LinkedListd {
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

    // Function to remove duplicates from the linked list
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                // Duplicate found, remove the node
                prev.next = current.next;
            } else {
                // If not a duplicate, add the value to the set
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
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

    // Main method to test the removeDuplicates function
    public static void main(String[] args) {
        LinkedListd list = new LinkedListd();
        list.append(5);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(2);
        list.append(1);
        list.append(4);
        list.append(5);
        list.append(3);

        System.out.println("Original list:");
        list.printList();

        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.printList();
    }
}
