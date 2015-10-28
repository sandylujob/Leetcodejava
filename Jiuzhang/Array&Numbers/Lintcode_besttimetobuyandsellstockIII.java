/* Best Time to Buy and Sell Stock III 
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
*/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
       if (prices==null || prices.length==0) return 0;
       //add more condtion to check
       if (prices.length==1) return 0;
        int m=prices.length;
        int[] left=new int[m];
        int[] right=new int[m];
        int profit=0; int leftmin=Integer.MAX_VALUE;
        for (int i=0;i<m;i++) {
        	leftmin = (prices[i]<leftmin) ? prices[i]:leftmin;
        	if (i==0 ) 
     			{ left[i]=0;} else {
        	left[i]=Math.max(prices[i]-leftmin,left[i-1]); }
        }
        int rightmax=Integer.MIN_VALUE;
        //bug should j--, and j
        for (int j=m-1;j>=0;j--) {
       		rightmax=(prices[j]>rightmax) ? prices[j]:rightmax;
       		if (j==m-1) {
       			right[j]=0;
       		} else {
       		right[j]=Math.max(rightmax-prices[j],right[j+1]);
        	} 
        }

        for( int i=0 ;i<m; i++) {
        	profit=Math.max(profit,left[i]+right[i]);
        }
        return profit;
    }
};

