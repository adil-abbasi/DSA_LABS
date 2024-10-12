import java.util.Stack;


class Queuea {
    private Stack<Integer> s1, s2;

  
    Queuea() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

      public void enqueue(int data) {
        // Push item into the first stack
        System.out.println("Enqueuing: " + data);
        s1.push(data);
    }

    
    public int dequeue() {
        // If both stacks are empty, no elements to dequeue
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(0);
        }

      
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

       
        return s2.pop();
    }}
public class Main5{
    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};
        Queuea q = new Queuea();

       
        for (int key : keys) {
            q.enqueue(key);
        }

       
        System.out.println(q.dequeue()); // print 1
        System.out.println(q.dequeue()); // print 2
    }
}
