/* Leetcode 104 Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
      if (root==null) return 0;
      return maxDepthhelper(root, 0);
    }

    public int maxDepthhelper(TreeNode root, int max){
    	if (root == null) return max;
    	int leftmax = maxDepthhelper(root.left,max+1);
    	int rightmax = maxDepthelper(root.right,max+1);

    	if (leftmax > rightmax) {
    		return leftmax;
    	} else {
    		return rightmax;
    	}
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
      if (root==null) return 0;
  		int left = maxDepth(root.left);
  		int right = maxDepth(root.right);
  		return Math.max(left,right)+1;
}