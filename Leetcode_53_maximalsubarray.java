/* Leetcode 53 Maximum Subarray 
*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
*For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
*the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
*/

import java.lang.Math;

public class Solution {
    public int maxSubArray(int[] nums) {
        int ret= nums[0] ; int sum = 0;
        for (int i = 0 ; i< nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            ret = Math.max(ret, sum) ;
        }
    
        return ret;
    }

    //normal one
    public int maxSubArray(int[] nums) {
    	int max = nums[0] ;
    	int[] sum = new int[nums.length];
    	sum[0]= nums[0];
    	//start from 1
    	for (int i = 1; i< nums.length; i++) {
    		sum[i] = Math.max(nums[i], sum[i-1]+nums[i]);
    		max = Math.max(max, sum[i]) ;
    	}

    	return max;
    }
}