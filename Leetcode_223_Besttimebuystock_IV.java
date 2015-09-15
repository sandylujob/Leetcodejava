/*
* Leetcode 123 Best time to buy and sell Stock IV
*Say you have an array for which the ith element is the price of a given stock on day i.
*Design an algorithm to find the maximum profit. You may complete at most K
*transactions.
*Note:
*You may not engage in multiple transactions at the same time (ie, you must sell the 
*stock before you buy again).
*/
import java.lang.Math;

public class Solution {
    public int maxProfit(int k, int[] prices) { {
        if (prices.length < 2 ) return 0 ;
        if (k > prices.length / 2) return sloveMaxProfit(prices) ;
        int[] global = new int[k+1]();
        int[] local = new int[k+1]();

        for (int i = 0; i< prices.length; ++i) {
            int diff = prices[i+1] - prices[i];
            for ( int j= k ; j >= 1; --j) {
                local[j] = Math.max(global[j-1] + Math.max(diff,0), local[j-1]+diff);
                global[j] = Math.max(global[j], local[j])
            }
        }
        return global[k];
    }

    int sloveMaxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i< prices.length; ++i) {
            if (prices[i] - prices[i-1] > 0) {
                res += prices[i] -prices[i-1] ;
            }
        }
    retrurn res ;
    }
}