class Solution {
    public static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];

        // dp[i][i] = 0 (one matrix)
        for (int i = 1; i < N; i++) {
            dp[i][i] = 0;
        }

        // chain length from 2 to N-1
        for (int len = 2; len < N; len++) {
            for (int i = 1; i < N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // try every partition
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 4};
        System.out.println(matrixMultiplication(arr1.length, arr1)); // 20

        int[] arr2 = {1, 2, 3, 4, 3};
        System.out.println(matrixMultiplication(arr2.length, arr2)); // 30

        int[] arr3 = {3, 4};
        System.out.println(matrixMultiplication(arr3.length, arr3)); // 0
    }
}
