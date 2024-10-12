
class Node {
    int data; 
    Node next; 

    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stacka {
    private Node top;

    
    public Stacka() {
        this.top = null;
    }

    public void push(int x) {
        System.out.println("Inserting " + x);
        Node newNode = new Node(x);
        newNode.next = top; 
        top = newNode; 
    }

    
    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1; 
        }
    }

   
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Program Terminated.");
            System.exit(1);
        }
        System.out.println("Removing " + top.data);
        top = top.next; // Update top to the next node
    }
}

public class Main2 {
    public static void main(String[] args) {
        Stacka stack = new Stacka();

        stack.push(1); // Inserting 1 into the stack
        stack.push(2); // Inserting 2 into the stack
        stack.push(3); // Inserting 3 into the stack

        System.out.println("Top element is " + stack.peek()); // Peek the top element

        stack.pop(); // Removing top element (3)
        stack.pop(); // Removing top element (2)
        stack.pop(); // Removing top element (1)

        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}
