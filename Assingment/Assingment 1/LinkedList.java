class LinkedList {
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

    // Function to get the nth node from the end of the linked list
    public int nthFromLast(int n) {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return -1; // Returning -1 to indicate the list is empty
        }

        Node mainPtr = head;
        Node refPtr = head;

        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                System.out.println("n is greater than the number of nodes in the list");
                return -1;
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        return mainPtr.data;
    }

    // Utility function to add a new node at the end of the list
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

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

    // Main method to test the nthFromLast function
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        list.printList();

        int n = 2;
        int result = list.nthFromLast(n);
        if (result != -1) {
            System.out.println("The " + n + "th node from the end is: " + result);
        }
    }
}
