class Solution {
    public static int knapSack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] val1 = {1, 2, 3};
        int[] wt1 = {4, 5, 1};
        System.out.println(knapSack(4, wt1, val1, 3)); // Output: 3

        int[] val2 = {1, 2, 3};
        int[] wt2 = {4, 5, 6};
        System.out.println(knapSack(3, wt2, val2, 3)); // Output: 0

        int[] val3 = {10, 40, 30, 50};
        int[] wt3 = {5, 4, 2, 3};
        System.out.println(knapSack(5, wt3, val3, 4)); // Output: 80
    }
}
