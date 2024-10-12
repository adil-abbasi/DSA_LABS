public class NLArray {

    // Function to extract and print the boundaries of a 2D array
    public static void extractBoundaries(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;

        // Print the first row
        for (int j = 0; j < cols; j++) {
            System.out.print(arr[0][j] + " ");
        }
        System.out.println();

        // Print the first and last column of the middle rows
        for (int i = 1; i < rows - 1; i++) {
            System.out.print(arr[i][0] + " "); // First column
            for (int j = 1; j < cols - 1; j++) {
                System.out.print("  "); // Space for the center part
            }
            System.out.println(arr[i][cols - 1]); // Last column
        }

        // Print the last row
        for (int j = 0; j < cols; j++) {
            System.out.print(arr[rows - 1][j] + " ");
        }
        System.out.println();
    }

    // Function to extract and print the center part of a 2D array (excluding boundaries)
    public static void cropCenterPart(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;

        // Loop through the center part (excluding the first and last row/column)
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        System.out.println("Boundaries:");
        extractBoundaries(arr);

        System.out.println("Center Part:");
        cropCenterPart(arr);
    }
}
