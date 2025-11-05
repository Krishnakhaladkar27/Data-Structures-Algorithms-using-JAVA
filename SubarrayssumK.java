import java.util.*;

class Solution {
    public int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int sum = 0;
        int count = 0;

        prefixSumCount.put(0, 1); // handle subarrays starting from index 0

        for (int num : arr) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count; // make sure to return
    }
}

public class Main {
    public static void main(String[] args) {
        Solution ob = new Solution();
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        int ans = ob.subarraySum(arr, k); // match method name exactly
        System.out.println(ans); // Output: 3
    }
}
