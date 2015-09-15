/*
* Leetcode 123 Best time to buy and sell Stock III
*Say you have an array for which the ith element is the price of a given stock on day i.
*Design an algorithm to find the maximum profit. You may complete at most two 
*transactions.
*Note:
*You may not engage in multiple transactions at the same time (ie, you must sell the 
*stock before you buy again).
*/
import java.lang.Math;

public class Solution {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        if  (m == 0 || m < 2 ) return 0 ;

        int[] left =new int[m];
        int[] right = new int[m];

        left[0] = 0;
        int min = prices[0];
        for (int i = 1 ; i< m ; i++) {
        	min = Math.min(min, prices[i]);
        	left[i] = Math.max(left[i-1], prices[i]-min);
        }

        right[m-1]=0;
        int max = prices[m-1];
        for (int i = m-2 ; i >=0 ; i--) {
        	max = Math.max(max,prices[i]);
        	right[i] = Math.max(right[i+1], max-prices[i]);
        	}

        	int profit = 0;
        	for (int i = 0; i< m ; i++ ) {
        		profit = Math.max(profit, left[i]+right[i]) ;
        	}
        	return profit ;
        }
    }
}