import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr2 {

    // Function to read a file and return a list of words, ignoring punctuation marks
    public static String[] wordTokenize(String fileName) {
        ArrayList<String> wordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Removing punctuation (.,:;!?) and splitting by whitespace
                line = line.replaceAll("[.,:;!?]", "");
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Converting ArrayList to Array
        return wordsList.toArray(new String[0]);
    }

    // Function to read a file and return all emails found within it
    public static String[] extractEmail(String fileName) {
        ArrayList<String> emailsList = new ArrayList<>();
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(emailRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    emailsList.add(matcher.group());
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Converting ArrayList to Array
        return emailsList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        String fileName = "example.txt";

        String[] words = wordTokenize(fileName);
        System.out.println("Words from file:");
        for (String word : words) {
            System.out.println(word);
        }

        String[] emails = extractEmail(fileName);
        System.out.println("\nEmails from file:");
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
