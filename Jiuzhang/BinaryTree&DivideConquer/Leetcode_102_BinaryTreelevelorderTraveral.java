/* Leetcode 102 Binary Tree Level Order Traversal 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

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

 // BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    		List<List<Integer>> ret = new ArrayList<List<Integer>> ();
        if (root == null) return ret;
        
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
 				queue.offer(root);
 				while (!queue.isEmpty()) {
 					List<Integer> temp = new ArrayList<Integer>();
 					int size = queue.size();
 					for (int i =0; i<size; i++) {
 						TreeNode head = queue.poll();
 						temp.add(head.val);
 						if (head.left != null) {
 							  queue.offer(head.left);
 						}
 						if (head.right != null) {
 							  queue.offer(head.right);
 						}
 					}
 					ret.add(temp);
 				}
 				return ret;
    }

  // DFS   
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

			if (root == null) {
				 return ret;
			}

			int maxlevel = 0; 
			while (true) {
				 ArrayList<Integer> level = new ArrayList<Integer>();
				 dfs(root,level,0, maxlevel);
				 if (level.size() ==0) {
				 		break;
				 }

				 ret.add(level);
				 maxlevel++;
			}
		}

		private void dfs(TreeNode root, ArrayList<Integer> level, int curlevel, int maxlevel) {
			if (root==null|| curlevel> maxlevel) {
				return ;
			}

			if (curlevel==maxlevel) {
				level.add(root.val);
				return;
			}

			dfs(root.left,level,curlevel+1, maxlevel);
			dfs(root.right,level,curlevel+1, maxlevel);
		}

}