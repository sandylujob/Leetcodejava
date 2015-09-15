/*
* Leetcode 97 Unique Binary Search Trees II
*Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
*For example,
*Given n = 3, your program should return all 5 unique BST's shown below. 
*
*   1         3     3      2      1
*    \       /     /      / \      \
*     3     2     1      1   3      2
*    /     /       \                 \
*   2     1         2                 3
*
*confused what "{1,#,2,3}" means?
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
// Fail List<TreeNode> can't be translate to ArrayList<TreeNode>
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	if (n == 0) return generates(1,0);
      return generates(1, n);  
    }

    public List<TreeNode> generates(int begin, int end) {
    	List<TreeNode> treeresult= new ArrayList<TreeNode>() ; 
    	if (begin > end)  {
    		treeresult.add(null);
    		return treeresult;
    	}

    	for ( int i = begin ; i <= end ; ++i ) {
    		List<TreeNode> lefttree = generates(begin, i-1) ;
    		List<TreeNode> righttree = generates(i+1, end) ;
    			for (int j = 0 ; j < lefttree.size() ; ++j) {
    				for (int k = 0 ; k < righttree.size(); ++k) {
    					TreeNode node = new TreeNode(i);
    					treeresult.add(node);
    					node.left = lefttree.get(j);
    					node.right = righttree.get(k);
    				}
    			}
    	} return treeresult;
  }
}