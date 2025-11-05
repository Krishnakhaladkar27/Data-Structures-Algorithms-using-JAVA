class Solution {
    
    static boolean matSearch(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            // Binary search in row i
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mat[i][mid] == x) {
                    return true; // Element found
                } else if (mat[i][mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false; // Element not found
    }
}
