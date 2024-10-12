import java.util.Arrays;

public class InsertionSorta {

    // Function to sort exactly 4 elements using Insertion Sort
    public void sortFourElements(int[] array) {
        
        if (array.length != 4) {
            System.out.println("Array must contain exactly 4 elements.");
            return;
        }

        int comparisonCount = 0; // To keep track of number of comparisons

        // Insertion Sort logic
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Compare elements and shift them as necessary
            while (j >= 0 && array[j] > key) {
                System.out.println("Comparing " + array[j] + " and " + key); // Print each comparison
                comparisonCount++; // Increment comparison count
                array[j + 1] = array[j]; // Shift element
                j--;
            }

            // Print the final comparison when breaking the loop
            if (j >= 0) {
                System.out.println("Comparing " + array[j] + " and " + key);
                comparisonCount++; // Increment comparison count
            }

            array[j + 1] = key; // Place key in the correct position
        }

        // Final output of the total comparisons
        System.out.println("Total Comparisons: " + comparisonCount); // Print total comparisons
    }

    public static void main(String[] args) {
        InsertionSorta sorter = new InsertionSorta();
        int[] array = {4, 3, 2, 1};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        sorter.sortFourElements(array);

        System.out.println("Sorted Array (Insertion Sort):");
        System.out.println(Arrays.toString(array));
    }
}
