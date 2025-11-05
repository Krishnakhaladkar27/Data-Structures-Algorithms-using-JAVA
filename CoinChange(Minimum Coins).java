import java.util.Arrays;

class Solution {
    public static int minCoins(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // Base case: no coins needed for sum 0

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }

    public static void main(String[] args) {
        int[] coins1 = {25, 10, 5};
        System.out.println(minCoins(coins1, 30)); // Output: 2

        int[] coins2 = {9, 6, 5, 1};
        System.out.println(minCoins(coins2, 19)); // Output: 3

        int[] coins3 = {5, 1};
        System.out.println(minCoins(coins3, 0)); // Output: 0

        int[] coins4 = {4, 6, 2};
        System.out.println(minCoins(coins4, 5)); // Output: -1
    }
}
