import java.util.*;

class Solution {
    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(longestCommonSubsequence(s1, s2)); // Output: 3

        s1 = "ABC";
        s2 = "AC";
        System.out.println(longestCommonSubsequence(s1, s2)); // Output: 2

        s1 = "XYZW";
        s2 = "XYWZ";
        System.out.println(longestCommonSubsequence(s1, s2)); // Output: 3
    }
}
