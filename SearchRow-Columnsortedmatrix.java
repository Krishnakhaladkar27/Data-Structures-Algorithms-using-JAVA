class Solution {
    // Function to search x in a row-column sorted matrix
    static boolean search(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        // Start from top-right corner
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true;  // Element found
            } else if (mat[row][col] > x) {
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }

        return false;  // Element not found
    }
}
