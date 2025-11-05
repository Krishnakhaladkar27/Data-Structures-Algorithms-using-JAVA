//Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.
import java.util.*;

public class Solution {

    // Make this method static
    public static int maximumProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 10, 1, 3, 6, 9, 2};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, 3, 6, 9, 11};

        System.out.println(maximumProfit(prices1)); // 8
        System.out.println(maximumProfit(prices2)); // 0
        System.out.println(maximumProfit(prices3)); // 10
    }
}
