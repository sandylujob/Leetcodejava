/* Leetcode 285 Inorder Successor in BST
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Have you met this question in a real interview?
Example

Given tree = [2,1] and node = 1:

  2
 /
1

return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3

return node 3.
Note

If the given node has no in-order successor in the tree, return null.
Challenge

O(h), where h is the height of the BST.
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
//recusrive version, without father
//condition with bst
// if root == p, if right != null right substree left most
//  right == null, it is the father . save the father.
// if root > p, in left substree. save the successor->father.
// if root < p, in right subtree. the previous successor still the same till updated


public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
		return helper(root, p, null);
	}
	public TreeNode helper(TreeNode root, TreeNode p, TreeNode successor){
		if (root == null) return null;
		if (root.val==p.val) {
			if (root.right !=null) {
				return findMin(root.right);
			} else {
				return successor;
			}
		}
		if (root.val > p.val) {
			return helper(root.left,p, root);} 
			else 
				{ return helper(root.right,p, successor);}
		}
		public TreeNode findMin(TreeNode root) {
			if (root == null) return null;
			while(root.left != null) {
				root= root.left;
			}
			return root;
		}

	// not recusrive
		public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
			 if (p.right !=null) {
			 			return findMin(p.right) ;
			 }
			 TreeNode successor = null;
			 while (root !=null) {
			 		if (root.val > p.val) {
			 				successor = root ;
			 				root = root.left;
			 		} else if (root.val < p.val ) {
			 				root = root.right;
			 		} else {
			 			return successor
			 		}
			 }
			return null;
		}
		// with parent link
		public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
			if (p.right !=null) {
					return findMin(p.right);
			}
			TreeNode parent = p.parent;
			while (parent!=null && parent.right==p) {
				  p = parent;
				  parent = parent.parent;
			}
			return parent;
	}

