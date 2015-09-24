/* Leetcode 55 Jump Game
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
*/
/*
 idea, for jump success, it should look back.
 start with length-1,
 jump key should be just >= distances
 nums[i] >= cur-i then cur = i;
 end cur ==0
*/
public class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for (int i = last-1; i>0 ; i--) {
        	if (nums[i]>=cur-i) {
        		cur = i;
        	}
        }
        return cur == 0;
    }
}
//followup reutn minmum number of jumps to reach the last index
