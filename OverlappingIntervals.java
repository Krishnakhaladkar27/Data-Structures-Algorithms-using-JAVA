import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        ArrayList<int[]> merged = new ArrayList<>();
        if (arr == null || arr.length == 0) return merged;

        // Sort intervals by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= current[1]) {
                // Overlap: merge
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                // No overlap: add current
                merged.add(current);
                current = arr[i];
            }
        }

        // Add last interval
        merged.add(current);

        return merged;
    }
}
