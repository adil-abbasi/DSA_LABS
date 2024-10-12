// Node class for SingleLinkedList with tail
class SingleNode {
    String name;
    SingleNode next;

    SingleNode(String name) {
        this.name = name;
        this.next = null;
    }
}

public class SingleLinkedListWithTail {
    SingleNode head, tail;

    // Constructor
    public SingleLinkedListWithTail() {
        head = null;
        tail = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(String name) {
        SingleNode newNode = new SingleNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(String name) {
        SingleNode newNode = new SingleNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
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
            SingleNode temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    // Print all nodes
    public void printAll() {
        SingleNode temp = head;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedListWithTail list = new SingleLinkedListWithTail();
        
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
