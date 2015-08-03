/*
*Say you have an array for which the ith element is the price of a given stock on day i.
*If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

import java.lang.Math;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        int minVal = Integer.Max_VALUE;

        for (int i = 0; i< prices.length; i++) {
        	if (prices[i] < minVal) {
        		minVal = prices[i] ;
        	}
        	maxVal = Math.max(prices[i]-minVal, maxVal); 
        }
        return maxVal ;
    }
}
