/*
* Leetcode 96 Unique Binary Search Trees
*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
*For example,
*Given n = 3, there are a total of 5 unique BST's.
*
*   1         3     3      2      1
*    \       /     /      / \      \
*     3     2     1      1   3      2
*    /     /       \                 \
*   2     1         2                 3
*/
import java.lang.Math;

public class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0]=1;
        if (n>0) nums[1]=1;
        for (int i = 2 ; i< n+1; i++) {
        	for (int j = 0 ; j< i ; j++) {
        		nums[i] += nums[j] * nums[i-j-1];
        	}
        }
      return nums[n];
    }
}