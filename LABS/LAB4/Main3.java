class Queue {
    private int arr[];
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor to initialize queue
    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Utility function to remove front element from the queue and check for Queue Underflow
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow. Program Terminated.");
            System.exit(1);
        }

        System.out.println("Removing " + arr[front]);
        front = (front + 1) % capacity;
        count--;
    }

    // Utility function to add an item to the queue and check for Queue Overflow
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow. Program Terminated.");
            System.exit(1);
        }

        System.out.println("Inserting " + item);
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    // Utility function to return front element in the queue and check for Queue Underflow
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            System.exit(1);
        }
        return arr[front];
    }

    // Utility function to return the size of the queue
    public int size() {
        return count;
    }

    // Utility function to check if the queue is empty or not
    public boolean isEmpty() {
        return count == 0;
    }

    // Utility function to check if the queue is full or not
    public boolean isFull() {
        return count == capacity;
    }
}

// Main class
public class Main3 {
    public static void main(String[] args) {
        // create a queue of capacity 5
        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front element is: " + q.peek());

        q.dequeue();
        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty()) {
            System.out.println("Queue Is Empty");
        } else {
            System.out.println("Queue Is Not Empty");
        }
    }
}
