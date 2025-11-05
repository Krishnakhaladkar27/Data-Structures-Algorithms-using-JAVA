class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);

        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20})); 
        // Output: 15

        System.out.println(minCostClimbingStairs(
            new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        ));
        // Output: 6
    }
}
