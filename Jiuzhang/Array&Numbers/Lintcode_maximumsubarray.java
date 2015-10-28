/* lintcode maximum subarray
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums==null) return 0;
        int m=nums.length;
        int max=nums[0];
        int sum=new int[m];
        sum[0]=nums[0];
        for (int i =1; i<m; i++) {
        	sum[i]=Math.max(nums[i],sum[i-1]+nums[i]);
        	max=Math.max(max,sum[i]);
        }
        return max;
    }
}
