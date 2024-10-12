class Nodea {  // Keep the class name consistent
    int data;
    Nodea next;  // Use the correct type

    // Constructor
    Nodea(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedLista {
    Nodea head;  // Use the correct type

    // Method to add a node to the back of the list
    void addToBack(int data) {
        Nodea node = new Nodea(data);  // Correct class name

        if (head == null) {
            head = node;
        } else {
            Nodea n = head;  // Use the correct type
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    // Method to print the list
    void printList() {
        Nodea node = head;  // Use the correct type
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Method to add a node to the front of the list
    void addToFront(int data) {
        Nodea node = new Nodea(data);  // Correct class name
        node.next = head;
        head = node;
    }

    // Method to add a node in the middle at a specific index
    void addMiddle(int index, int data) {
        Nodea node = new Nodea(data);  // Correct class name
        if (index == 1) {
            addToFront(data);
            return;
        }

        Nodea n = head;  // Use the correct type
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
            Nodea n = head;  // Use the correct type
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
            Nodea n = head;  // Use the correct type
            for (int i = 1; i < index - 1 && n.next != null; i++) {
                n = n.next;
            }

            if (n.next != null) {
                n.next = n.next.next;
            }
        }
    }
    

    boolean search(int target) {
        Nodea node = head;
        while (node != null) {
            if (node.data == target) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    int getLength() {
        int length = 0;
        Nodea node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    // Method to check if the list is empty
    boolean isEmpty() {
        return head == null;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedLista ll = new LinkedLista();
       ll.addToBack(5);
       ll.addToBack(19);

        ll.addToBack(19);
       // ll.printList(); // Output: 5 19 19

        ll.addToFront(20);
//        ll.printList(); // Output: 20 5 19 19

        ll.addMiddle(2, 200);
//        ll.removeFromFront();
//        ll.removeFromBack();
//        ll.removeFromBack();
        
 //       ll.removeAt(3);
System.out.println("THE LENGTH OF LIST IS");
        System.out.println(ll.getLength());
        ll.printList(); // Output: 20 200 5 19 19
       
        int target = 200;
        if (ll.search(target)) {
            System.out.println("Element " + target + " is found in the list.");
        } else {
            System.out.println("Element " + target + " is not found in the list.");
            
        }
  
        
       
    }
}
