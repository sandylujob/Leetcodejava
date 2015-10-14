/* leetcode 153 Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

*/
//draw a graph, it will more clear.
//select the target, otherwise more complicated for analysis
//Find Minimum/Maximum/Target

public class Solution {
    public int findMin(int[] nums) {
       if (nums==null|| nums.length==0) 
       { return -1; }
       if (nums.length==1) return nums[0];

       int start = 0;
       int end = nums.length-1;
       //need target 
       int target = nums[nums.length-1];
       while (start + 1 < end) {
       	int mid = start + (end - start) / 2 ;
       	if ( nums[mid] <= target) {
       			end = mid
       	} else {
       		 start = mid ;
       	}
   				}

   			if (nums[start] <= target) {
   				return nums[start];
   			} 
   			else {
   				return nums[end];
   			}
    }
}