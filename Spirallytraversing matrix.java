import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> spirallyTraverse(int[][] mat, int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
