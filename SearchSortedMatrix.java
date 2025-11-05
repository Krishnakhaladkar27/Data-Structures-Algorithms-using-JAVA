class Solution {
    static boolean matSearch(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == x) {
                return true;  // Element found
            } else if (mat[row][col] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;  // Element not found
    }
}
