/* Leetcode 45  jump game 2
* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
**/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A==null || A.length ==0) return -1;
        int n = A.length;
        int[] ret = new int[n];
        ret[0] =0; 
        for (int i = 1; i <n ; i++) {
        		int minnum = Integer.MAX_VALUE;
        	for (int j = 0; j< i ; j++) {
        			if (A[j]>= i-j && ret[j]< minum) {
        				 minnum = ret[j];
        			}
        	}
        	ret[i] = minnum + 1;
        }
        return ret[n-1];
    }
}

