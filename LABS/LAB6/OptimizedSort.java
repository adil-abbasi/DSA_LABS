import java.util.Arrays;

public class OptimizedSort {

    // Function to sort exactly 4 elements with 5 comparisons
    public void sortFourElements(int[] array) {
        
        if (array.length != 4) {
            System.out.println("Array must contain exactly 4 elements.");
            return;
        }

        int comparisonCount = 0; // To keep track of number of comparisons

        // First comparison: Compare first two elements
        if (array[0] > array[1]) {
            int temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
        comparisonCount++;

        // Second comparison: Compare third element with the smaller of the first two
        if (array[2] < array[0]) {
            int temp = array[2];
            array[2] = array[0];
            array[0] = temp;
        }
        comparisonCount++;

        // Third comparison: Compare third element with the larger of the first two
        if (array[2] < array[1]) {
            int temp = array[2];
            array[2] = array[1];
            array[1] = temp;
        }
        comparisonCount++;

        // Fourth comparison: Compare fourth element with the first three sorted elements
        if (array[3] < array[0]) {
            int temp = array[3];
            array[3] = array[0];
            array[0] = temp;
        }
        comparisonCount++;

        // Fifth comparison: Place fourth element in correct position
        if (array[3] < array[1]) {
            int temp = array[3];
            array[3] = array[1];
            array[1] = temp;
        }
        comparisonCount++;

        // Final check for the last position
        if (array[2] > array[3]) {
            int temp = array[2];
            array[2] = array[3];
            array[3] = temp;
        }

        System.out.println("Total Comparisons: " + comparisonCount); // Print total comparisons
    }

    public static void main(String[] args) {
        OptimizedSort sorter = new OptimizedSort();
        int[] array = {4, 3, 2, 1};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        sorter.sortFourElements(array);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));
    }
}
   