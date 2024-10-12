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
   
    public Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public void printList(Node node) {
        if (node == null) {
            System.out.println("NULL");
            return;
        }
        while (node != null) {
            System.out.print(node.data + (node.next != null ? " -> " : " -> NULL"));
            node = node.next;
        }
        System.out.println();
    }
   
    public void printReverse() {
        printReverseUtil(head);
    }

   
    private void printReverseUtil(Node node) {
        if (node == null) {
              return;
        }
        printReverseUtil(node.next);        
        System.out.print(node.data + (node != head ? " -> " : " -> NULL"));
    }

    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }
}

public class Main1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);

        System.out.println("Original Linked List:");
        list.printList(list.head);

        System.out.println("Reversed Linked List:");
        list.printReverse();  
    }
}
