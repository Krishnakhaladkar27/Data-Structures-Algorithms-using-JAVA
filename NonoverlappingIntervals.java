import java.util.*;

class Solution {
    public int minRemoval(int[][] intervals) {
        // Step 1: Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        // Step 2: Traverse and count overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap → remove current
                removals++;
            } else {
                // Non-overlapping → keep and update end
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
