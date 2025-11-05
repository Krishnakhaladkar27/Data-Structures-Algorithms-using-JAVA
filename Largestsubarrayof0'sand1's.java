import java.util.*;

class Solution {
    public int maxLen(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Treat 0 as -1 to convert problem into finding subarray with sum = 0
            sum += (arr[i] == 0) ? -1 : 1;

            if (sum == 0) {
                maxLen = i + 1;  // from start to i
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence of sum
            }
        }

        return maxLen;
    }
}
