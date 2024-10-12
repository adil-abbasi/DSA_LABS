class Stack {
   
    private int[] arr;
    private int top;
    private int capacity;
    
    public Stack(int size) {
        arr = new int[size]; 
        capacity = size;     
        top = -1;           
    }
  
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
   
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }
   
        top++;
        arr[top] = x;
        System.out.println("Pushed " + x + " onto the stack.");
    }

    // Remove the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return -1; // Return a sentinel value to indicate underflow
        }

        
        int poppedElement = arr[top];

       
        top--;

        System.out.println("Popped " + poppedElement + " from the stack.");
        return poppedElement;
    }

   
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Return a sentinel value to indicate empty stack
        }

        return arr[top];
    }

    public int size() {
        return top + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(3); // Create a stack with a capacity of 3

        stack.push(1); 
        stack.push(2); 
        stack.pop();   

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        stack.pop();   // Pop the top element (1)

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack is not empty.");
        }
    }
}