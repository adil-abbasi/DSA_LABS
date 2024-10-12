import java.util.Scanner;

public class Recursiona {

    // Recursive function to print in ascending order
    public static void printAscending(int n) {
        if (n == 0) {
            return;
        }
        printAscending(n - 1);
        System.out.print(n + " "); 
    }
   
    public static void printDescending(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " "); 
        printDescending(n - 1); 
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        System.out.print("Enter a number (N): ");
        int N = sc.nextInt();
        
        
        System.out.println("Numbers in ascending order:");
        printAscending(N);
        System.out.println();
        
       
        System.out.println("Numbers in descending order:");
        printDescending(N);
        System.out.println();
        
        sc.close();
    }
}
