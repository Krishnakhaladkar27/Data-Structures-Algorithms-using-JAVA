class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);           // Best price to buy 1st stock
            sell1 = Math.max(sell1, price - buy1);  // Best profit from 1st sale
            buy2 = Math.min(buy2, price - sell1);   // Effective cost after 1st profit
            sell2 = Math.max(sell2, price - buy2);  // Best total profit
        }

        return sell2;
    }

    public static void main(String[] args) {
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(prices1)); // Output: 87

        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(maxProfit(prices2)); // Output: 100
    }
}
