/* Leetcode 144 Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
 //recursive version Divide & Conquer
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tlist = new ArrayList<Integer>();
        if (root==null) return tlist;
        tlist.add(root.val);
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        tlist.addAll(left);
        tlist.addAll(right);
        return tlist;
    }
}

//iterative DFS
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
  			Stack<TreeNode> stack = new Stack<TreeNode>();
  			List<Integer> tlist = new ArrayList<Integer>();

  			if (root == null) {
  			  	return tlist;
  			}
  			stack.push(root);
  			while (!stack.empty()) {
  				TreeNode node = stack.pop();
  				tlist.add(node.val);
  				if (node.left!=null) {
  					stack.push(node.left);
  				}
  				if (node.right!=null) {
  					stack.push(node.right);
  				}
  			}

  			return tlist;
  }

}