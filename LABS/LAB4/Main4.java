// A linked list node
class NodeC {
    int data;   // integer data
    NodeC next;  // pointer to the next node

    // Constructor to initialize a new node
    public NodeC(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueC {
    private static NodeC rear = null, front = null;

    // Utility function to remove front element from the queue (dequeue)
    public static int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1; // or throw an exception
        }

        int frontValue = front.data;
        front = front.next; // Move the front pointer to the next node

        // If the queue becomes empty, set rear to null as well
        if (front == null) {
            rear = null;
        }

        return frontValue;
    }

    // Utility function to add an item to the queue (enqueue)
    public static void enqueue(int item) {
        NodeC newNodea = new NodeC(item); // Create a new node with the given item

        if (rear == null) {
            // If queue is empty, both front and rear will point to the new node
            front = rear = newNodea;
        } else {
            // Link the new node at the end of the queue and update the rear
            rear.next = newNodea;
            rear = newNodea;
        }
    }

    // Utility function to return the front element in a queue
    public static int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return front.data;
    }

    // Utility function to check if the queue is empty or not
    public static boolean isEmpty() {
        return front == null;
    }
}

public class Main4 {
    public static void main(String[] args) {
        QueueC q = new QueueC();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.printf("Front element is %d\n", q.peek());

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        if (q.isEmpty()) {
            System.out.print("Queue is empty");
        } else {
            System.out.print("Queue is not empty");
        }
    }
}
