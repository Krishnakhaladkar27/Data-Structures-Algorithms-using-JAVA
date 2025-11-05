import java.util.*;

class Solution {
    public int longestSubarrayWithSumK(int[] arr, int k) {
        int n = arr.length;
        Map<Long, Integer> prefixMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            
            if (sum == k) {
                maxLen = i + 1;
            }

        
            if (prefixMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
            }

            if (!prefixMap.containsKey(sum)) {
                prefixMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
