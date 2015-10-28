/* lintcode Best time to buy and sell stock II
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
       if (prices==null||prices.length==0) return 0;
       int profit=0; int min=prices[0];
       for (int i=1;i<prices.length;i++){
       		if ((prices[i]-min) > 0) {
       			profit += prices[i]-min;
       		} 
       		min=prices[i];
       }
       return profit;

    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
