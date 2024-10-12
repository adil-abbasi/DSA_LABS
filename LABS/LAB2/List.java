// CustomList interface
 interface CustomList {
    public boolean isEmpty();
    public int size();
    public void add(Object item);
    public void add(int index, Object item);
    public void remove(int index);
    public void remove(Object item);
    public CustomList duplicate();
    public CustomList duplicateReversed();
}

// LinkedList class implementing the CustomList interface
class LinkedListb implements CustomList {
    private Node head;  // Dummy head node
    private int size;

    // Constructor
    public LinkedListb() {
        head = new Node(null);
        size = 0;
    }

    // Inner Node class
    private class Node {
        Object item;
        Node next;

        Node(Object item) {
            this.item = item;
            this.next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object item) {
        Node node = new Node(item);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    @Override
    public void add(int index, Object item) {
        if (index < 1 || index > size + 1) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node node = new Node(item);
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    @Override
    public void remove(Object item) {
        Node current = head;
        while (current.next != null) {
            if (current.next.item.equals(item)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public CustomList duplicate() {
        LinkedListb copy = new LinkedListb();
        Node current = head.next;  // Skip the dummy node
        while (current != null) {
            copy.add(current.item);
            current = current.next;
        }
        return copy;
    }

    @Override
    public CustomList duplicateReversed() {
        LinkedListb copy = new LinkedListb();
        Node current = head.next;  // Skip the dummy node
        while (current != null) {
            copy.add(1, current.item);
            current = current.next;
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ size: ").append(size).append(" - ");
        Node current = head.next;  // Skip the dummy node
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}

// Main class to test the LinkedList
public class List {
    public static void main(String[] args) {
        LinkedListb list = new LinkedListb();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(2, "D");  // Insert "D" at position 2
        System.out.println(list);  // Output: [                                                          size: 4 - A, D, B, C ]

        list.remove(2);  // Remove item at position 2
        System.out.println(list);  // Output: [ size: 3 - A, B, C ]

        list.remove("B");  // Remove the first occurrence of "B"
        System.out.println(list);  // Output: [ size: 2 - A, C ]

        CustomList duplicate = list.duplicate();
        System.out.println("Duplicate: " + duplicate);  // Output: Duplicate: [ size: 2 - A, C ]

        CustomList reversed = list.duplicateReversed();
        System.out.println("Reversed: " + reversed);  // Output: Reversed: [ size: 2 - C, A ]
    }
}
