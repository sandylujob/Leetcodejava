/* Leetcode 124 Binary Tree Maximum Path Sum
 Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 

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

/*
* need 2 type 1. whole tree max, 2. tree any root to other node single one
* compare with left, right , and cross(singleleft,singleright+root)
* nee compare 0 for condtion.
*/


public class Solution {
  	class Record {
			int treemax;
			int singlemax;
			Record(int treemax, int singlemax) {
				this.treemax=treemax;
				this.singlemax=singlemax;
			}
		}
    public int maxPathSum(TreeNode root) {
        return dfs(root).treemax;
    }

    public Record dfs(TreeNode root) {
    	
    		if (root == null) {
    			return new Record(Integer.MIN_VALUE,0); }

    		 Record left = dfs(root.left);
    		 Record right = dfs(root.right);

    		 int cross = root.val;
    		 cross +=Math.max(0,left.singlemax);
    		 cross +=Math.max(0,right.singlemax);

    		 //singlemax is with root
    		 int singlemax = Math.max(left.singlemax, right.singlemax);
    		 singlemax +=root.val;
    		 singlemax = Math.max(0,singlemax);

    		 int treemax = Math.max(left.treemax, right.treemax);
    		 treemax = Math.max(treemax,cross);

    		 return new Record(treemax,singlemax);
    		
    }
}