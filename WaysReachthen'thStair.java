class Solution {
    public static int countWays(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(1)); // Output: 1
        System.out.println(countWays(2)); // Output: 2
        System.out.println(countWays(4)); // Output: 5
    }
}
