import java.util.*;

class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int start = 0;
        int sum = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            // Shrink window from left if sum exceeds target
            while (sum > target && start < end) {
                sum -= arr[start];
                start++;
            }

            // Check if current window matches target
            if (sum == target) {
                result.add(start + 1);  // 1-based index
                result.add(end + 1);
                return result;
            }
        }

        result.add(-1);
        return result;
    }
}
