//The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
import java.util.*;

public class Solution  {
    
    public static int maximumProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }   
        return profit;
    } 
    
    
    public static void main(String[] args) {
        int[] prices1 = {100, 180, 260, 310, 40, 535, 695};
        int[] prices2 = {4, 2, 2, 2, 4};
        
        System.out.println(maximumProfit(prices1));
        System.out.println(maximumProfit(prices2));
    }
}