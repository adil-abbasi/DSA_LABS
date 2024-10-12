import java.util.Arrays;

public class IterativeMergeSort {

    
    public void mergeSort(int[] array) {
        int n = array.length;

        
        for (int currSize = 1; currSize < n; currSize *= 2) {
            
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
               
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);

                merge(array, leftStart, mid, rightEnd);
            }
        }
    }

    // Helper function to merge two sorted subarrays
    private void merge(int[] array, int leftStart, int mid, int rightEnd) {
        // Sizes of two subarrays to be merged
        int n1 = mid - leftStart + 1;
        int n2 = rightEnd - mid;

        // Temporary arrays to hold data for left and right subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[leftStart + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Initial indexes for left, right, and merged subarrays
        int i = 0, j = 0, k = leftStart;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        IterativeMergeSort ims = new IterativeMergeSort();
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        ims.mergeSort(array);

        System.out.println("Sorted Array (Iterative Merge Sort):");
        System.out.println(Arrays.toString(array));
    }
}
