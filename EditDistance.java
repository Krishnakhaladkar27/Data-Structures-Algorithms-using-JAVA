class Solution {
    public static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base cases
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],        // Remove
                        Math.min(dp[i][j - 1], dp[i - 1][j - 1]) // Insert, Replace
                    );
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("geek", "gesek")); // Output: 1
        System.out.println(editDistance("gfg", "gfg"));     // Output: 0
        System.out.println(editDistance("abcd", "bcfe"));   // Output: 3
    }
}
