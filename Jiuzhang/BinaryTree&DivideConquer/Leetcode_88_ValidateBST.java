/* Leetcode 88 Validate Binary Search Tree
 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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

 /*error it should be compare from the leaf to root not from root to leaf
// root == null, so not area in [max,min]

 */
 // recursives
public class Solution {
 	class Ret {
			 boolean is_bst;
			 int min;
			 int max;
			 Ret(boolean is_bst,int x, int y) {
			 		this.is_bst = is_bst;
			 		this.min = x;
			 		this.max = y;
			 }
		}
    public boolean isValidBST(TreeNode root) {
        Ret r = isValidBSThelper(root);
        return r.is_bst;
    }

    public Ret isValidBSThelper(TreeNode root) {
    		if (root == null) 
    		{ return new Ret(true,Integer.MAX_VALUE,Integer.MIN_VALUE); }
    		Ret left = isValidBSThelper(root.left);
    		Ret right = isValidBSThelper(root.right);
 				if (!left.is_bst ||!right.is_bst) {
    			return new Ret(false,0,0);
    			} 
    		if (root.left !=null && left.max >=root.val || root.right !=null && right.min<=root.val) {
    			return new Ret(false,0,0);
    		}
    			return new Ret(true,Math.max(root.val,left.min),Math.min(root.val,right.max));
    		}
    }

//Travers ?
public class Solution {
	private int lastVal = Integer.MIN_VALUE;
	private boolean firstNode = true;
 	public boolean isValidBST(TreeNode root) {
 			 if (root == null) {
 			 		return true;
 			 }
 			 if (!isValidBST(root.left)) {
 			 		return false;
 			 }
 			 if (!firstNode && lastVal >= root.val) {
 			 		return false;
 			 }
 			 firstNode = false;
 			 lastVal = root.val;
 			 if (!isValidBST(root.right)) {
 			 		return false;
 			 } 
 			 return true;
 		}

}