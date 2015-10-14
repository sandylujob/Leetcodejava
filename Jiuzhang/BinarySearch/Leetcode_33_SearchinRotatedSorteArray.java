/* Leetcode 33 Search in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
 			 if (nums==null||nums.length==0) return -1;
 			 if (nums.length==1) return (nums[0]==target) ? 0:-1;

 			 int start = 0;
 			 int end = nums.length-1;

 			 while (start + 1 < end) {
 			 	int mid = start + (end - start) / 2 ;
 			 	if (nums[start]<nums[mid]) {
 			 		if (nums[mid]<=target&& nums[start]>=target) {
 			 			end = mid;
 			 		} else {
 			 			start = mid;
 			 		} else if (nums[mid]<nums[end]) {
 			 			if (nums[mid]>=target&& nums[end]>=target) {
 			 				start = mid;
 			 			} else {
 			 				end = mid;
 			 			}
 			 		}
 			 	}
 			 }		
 			 if (nums[start]==target) {
 			 	return start;
 			 } else if (nums[end]==target) {
 			 	return end;
 			 }
 			 return -1;
    }
}