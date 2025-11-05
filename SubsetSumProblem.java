class Solution {
    public static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[] dp = new boolean[sum + 1];

        // Base case: sum = 0 is always possible
        dp[0] = true;

        for (int num : arr) {
            // Traverse backwards to avoid overwriting results of the same iteration
            for (int j = sum; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr1, 9));   // true

        int[] arr2 = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr2, 30));  // false

        int[] arr3 = {1, 2, 3};
        System.out.println(isSubsetSum(arr3, 6));   // true
    }
}
