import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    static int[][][] dp;

    public static int countWays(int N, String s) {
        dp = new int[N][N][2];
        for (int[][] matrix : dp)
            for (int[] row : matrix)
                Arrays.fill(row, -1);

        return solve(s, 0, N - 1, 1);
    }

    private static int solve(String s, int i, int j, int isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

        int ways = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            char op = s.charAt(k);

            int lt = solve(s, i, k - 1, 1);
            int lf = solve(s, i, k - 1, 0);
            int rt = solve(s, k + 1, j, 1);
            int rf = solve(s, k + 1, j, 0);

            if (op == '&') {
                if (isTrue == 1)
                    ways = (ways + (lt * rt) % MOD) % MOD;
                else
                    ways = (ways + (lt * rf) % MOD + (lf * rt) % MOD + (lf * rf) % MOD) % MOD;
            } else if (op == '|') {
                if (isTrue == 1)
                    ways = (ways + (lt * rt) % MOD + (lt * rf) % MOD + (lf * rt) % MOD) % MOD;
                else
                    ways = (ways + (lf * rf) % MOD) % MOD;
            } else if (op == '^') {
                if (isTrue == 1)
                    ways = (ways + (lt * rf) % MOD + (lf * rt) % MOD) % MOD;
                else
                    ways = (ways + (lt * rt) % MOD + (lf * rf) % MOD) % MOD;
            }
        }

        return dp[i][j][isTrue] = ways % MOD;
    }

    public static void main(String[] args) {
        String s1 = "T|T&F^T";
        System.out.println(countWays(s1.length(), s1)); // Output: 4

        String s2 = "T^F|F";
        System.out.println(countWays(s2.length(), s2)); // Output: 2
    }
}
