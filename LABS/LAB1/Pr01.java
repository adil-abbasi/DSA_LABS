import java.util.Arrays;

public class Pr01 {

    public static void noDup(int[][] arr2D, int[] arr1D) {
        int index = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int currentValue = arr2D[i][j];
                boolean found = false;
                
                // Check if currentValue is already in arr1D
                for (int k = 0; k < index; k++) {
                    if ( arr1D[k] == currentValue) {
                        found = true;
                        break;
                    }
                }

                // If currentValue is not found in arr1D, add it
                if (!found) {
                    arr1D[index++] = currentValue;
                }
            }
        }

        // Fill the rest of the 1D array with a sentinel value like 0 if necessary
        while (index < 20) {
            arr1D[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] arr2D = {
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 6},
            {3, 4, 5, 6, 7},
            {4, 5, 6, 7, 8}
        };
        int[] arr1D = new int[20];
        
        noDup(arr2D, arr1D);
        
        // Print the result
        System.out.println("1D Array with no duplicates: " + Arrays.toString(arr1D));
    }
}
