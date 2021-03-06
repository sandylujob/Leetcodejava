/* Leetcode 122 Best time buy stock 2
*Say you have an array for which the ith element is the price of a given stock on day i.
*Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). *However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
        	return 0 ;
        }

        int start = prices[0];
        int profit = 0;

        for (int i = 1; i< prices.length; i++) {
        		if (prices[i] >= prices[i-1]) {
        			continue ;
        		}

        		profit += (prices[i-1]-start) ;
        		start = prices[i];
        }
        profit += prices[prices.length-1] - start; 
        return profit;
    }
}