class Solution {
    public static boolean canPartition(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // If total sum is odd, cannot partition equally
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: sum 0 is always achievable

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) dp[j] = true;
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        System.out.println(canPartition(arr1)); // true

        int[] arr2 = {1, 3, 5};
        System.out.println(canPartition(arr2)); // false
    }
}
