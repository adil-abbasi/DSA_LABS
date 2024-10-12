import java.util.Scanner;

public class Fabnoci {

    // Iterative approach
    public static void fibonacciIterative(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series (Iterative): ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Recursive approach
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void printFibonacciRecursive(int n) {
        System.out.print("Fibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // User input for N
        System.out.print("Enter a number (N) for the Fibonacci series: ");
        int N = sc.nextInt();
        
        // Time and generate Fibonacci using iterative approach
        long startTimeIterative = System.nanoTime();
        fibonacciIterative(N);
        long endTimeIterative = System.nanoTime();
        long durationIterative = endTimeIterative - startTimeIterative;
        
       
        long startTimeRecursive = System.nanoTime();
        printFibonacciRecursive(N);
        long endTimeRecursive = System.nanoTime();
        long durationRecursive = endTimeRecursive - startTimeRecursive;
        
        
        System.out.println("Time taken by Iterative approach: " + durationIterative + " nanoseconds");
        System.out.println("Time taken by Recursive approach: " + durationRecursive + " nanoseconds");
        
        // Compare time
        if (durationIterative < durationRecursive) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }
        
        sc.close();
    }
}
