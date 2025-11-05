class Solution {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If k is larger than n/2, it becomes infinite transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int[] prices1 = {10, 22, 5, 80};
        System.out.println(maxProfit(2, prices1)); // Output: 87

        int[] prices2 = {20, 25, 30, 40, 10, 20};
        System.out.println(maxProfit(3, prices2)); // Output: 30

        int[] prices3 = {90, 80, 70, 60, 50};
        System.out.println(maxProfit(1, prices3)); // Output: 0
    }
}
