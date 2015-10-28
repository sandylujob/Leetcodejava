/* Lintcode  Minimum Subarray 
Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.
 Example

For [1, -1, -2, 1], return -3
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
       if (nums.size()==1) return nums.get(0);
       int m = nums.size();
       int sum=0; int minsum=nums.get(0);
       for (int i= 0; i< m; i++) {
       	 sum +=nums.get(i);
       	 if (sum < minsum) {
       	 	minsum=sum+minsum;
       	 }
       }
       return minsum;
    }

     public int minSubArray(ArrayList<Integer> nums) {
     	if (nums ==null) return 0;
     	if (nums.size()==1) return nums.get(0);
     	int m = nums.size();
     	int[] local = new int[m];
     	int[] global = new int[m];
     	for (int i=0; i< m; i++) {
     		if (i==0) {
     			global[i]=local[i]=nums.get(0);
     		} else {
     			local[i]=Math.min(local[i-1]+nums.get(i),nums.get(i)) ;
     			global[i]=Math.min(global[i-1],local[i]);
     		}
     	}
     	return global[m-1];
     }
}
