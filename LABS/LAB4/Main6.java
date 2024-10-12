import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> q1, q2;

    // Constructor to initialize the queues
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Method to add an item to the stack
    public void push(int data) {
        System.out.println("Pushing: " + data);

        // Push the new element into q2
        q2.add(data);

        // Transfer all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap the queues to ensure q1 always has the newest element on top
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Method to remove the top element from the stack
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }

        // Remove and return the front element from q1
        return q1.remove();
    }

    // Method to return the top element without removing it
    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Return the front element from q1
        return q1.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class Main6 {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Popped element is: " + stack.pop());

        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}
