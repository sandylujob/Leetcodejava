/*  Leetcode 35 Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums==null || nums.length==0 ) return 0;
        if (nums.length==1) return (nums[0]>=target)? 0:1;
        int start=0;
        int end=nums.length-1;
        int p;
        while (start<end) {
        	p = (start+end)/2;
        	if (nums[p]>target) {
        		 end=p;
        	} 
        	else if (nums[p]<target) {
        		start=p+1;
        	}
        	else {
        	return p;
        	}
        }
        if (nums[start]<target) return start+1;
        return start;
    }
}