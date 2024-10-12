import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.nextLine().toUpperCase();
        
        char result = firstSingleLetter(text.toCharArray(), text.length());
        
        if (result != '\0') {
            System.out.println("The first single letter is: " + result);
        } else {
            System.out.println("No single letter found.");
        }
        scanner.close();
    }

    public static char firstSingleLetter(char[] text, int n) {
        for (int i = 0; i < n; i++) {
            boolean isUnique = true;
             
            for (int j = 0; j < n; j++) {
                if (i != j && text[i] == text[j]) {
                    isUnique = false;
                    break;
                }
            }
           if (isUnique) {
                return text[i];
            }
        }
        return '\0';
    }
}
