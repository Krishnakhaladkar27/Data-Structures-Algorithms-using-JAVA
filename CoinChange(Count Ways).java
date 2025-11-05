class Solution {
    public static long count(int coins[], int n, int sum) {
        long[] dp = new long[sum + 1];
        dp[0] = 1; // Base case: one way to make sum 0 — use no coins.

        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 3};
        System.out.println(count(coins1, coins1.length, 4)); // Output: 4

        int[] coins2 = {2, 5, 3, 6};
        System.out.println(count(coins2, coins2.length, 10)); // Output: 5

        int[] coins3 = {5, 10};
        System.out.println(count(coins3, coins3.length, 3)); // Output: 0
    }
}
