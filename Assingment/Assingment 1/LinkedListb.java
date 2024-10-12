class LinkedListb {
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

    // Function to sort the linked list by swapping the nodes
    public void sort() {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return;
        }

        boolean swapped;
        Node ptr1;
        Node lptr = null;

        // Bubble sort implementation for linked list
        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    // Swap the nodes, not just the data
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
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

    // Main method to test the sort function
    public static void main(String[] args) {
        LinkedListb list = new LinkedListb();
        list.append(50);
        list.append(40);
        list.append(30);
        list.append(20);
        list.append(10);

        System.out.println("Original list:");
        list.printList();

        list.sort();

        System.out.println("Sorted list:");
        list.printList();
    }
}
