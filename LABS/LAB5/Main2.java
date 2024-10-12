import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with brackets:");
        String input = scanner.nextLine();
        
       
        if (!containsOnlyBrackets(input)) {
            System.out.println("WRONG INPUT ONLY BRACKETS");
            return; 
        }
        
        if (areBracketsBalanced(input)) {
            System.out.println("The brackets are balanced.");
        } else {
            System.out.println("The brackets are not balanced.");
        }
        
        scanner.close();
    }
    
    public static boolean containsOnlyBrackets(String str) {
        for (char ch : str.toCharArray()) {
          
            if (ch != '{' && ch != '}' && ch != '[' && ch != ']' && ch != '(' && ch != ')') {
                return false; 
            }
        }
        return true; 
    }
    
    public static boolean areBracketsBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false; 
                }
            }
        }
        return stack.isEmpty(); 
    }
    
    public static boolean isMatchingPair(char open, char close) {
        return (open == '{' && close == '}') ||
               (open == '[' && close == ']') ||
               (open == '(' && close == ')');
    }
}
