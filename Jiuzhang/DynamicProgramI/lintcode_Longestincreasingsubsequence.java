/* lintcode Longest Increasing Subsequence
* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.
Have you met this question in a real interview?
Example

For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
Challenge

Time complexity O(n^2) or O(nlogn)
 
*****************************************
*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        int len = nums.length;
        int[] ret = new int[len];
   
 				int max = 0
        for(int i = 0; i< len; i++ ) {
        	ret[i]=1;
        	for (int j=0; j<i ; j++) {
        		if (nums[j] <= nums[i]) {
        			 f[i]= (f[i] > f[j]+1 ) ? f[i] : f[j] + 1;
        		}
        	
        	if (f[i] > max) {
        		max = f[i];
        	}
        }
        }
        return max;
    }
}