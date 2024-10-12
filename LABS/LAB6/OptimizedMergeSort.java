import java.util.Arrays;

public class OptimizedMergeSort {

    private int comparisonCount = 0; // To keep track of number of comparisons

    // Function to sort exactly 4 elements using Merge Sort
    public void sortFourElements(int[] array) {
        
        if (array.length != 4) {
            System.out.println("Array must contain exactly 4 elements.");
            return;
        }

        int[] sortedArray = mergeSort(array);
        
        // Display the sorted array
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Total Comparisons: " + comparisonCount); // Print total comparisons
    }

    private int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Merge process
        while (i < left.length && j < right.length) {
            comparisonCount++;
            System.out.println("Comparing " + left[i] + " and " + right[j]);

            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        OptimizedMergeSort sorter = new OptimizedMergeSort();
        int[] array = {4, 3, 2, 1};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        sorter.sortFourElements(array);
    }
}
