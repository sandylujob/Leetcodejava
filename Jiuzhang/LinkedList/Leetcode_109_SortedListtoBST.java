/* Leetcode 109 Convert Sorted List to Binary Search Tree 
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
	private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head==null ) {
        	return null;
        } 
        if (head.next==null) {
        	return new TreeNode(head.val);
        }
        int i = 0;
        ListNode temp = head;
        while (head !=null) {
        	head = head.next;
        	i++;
        }
        current=temp;
        return listtoBSThelper(0, i-1);
    }

    private TreeNode listtoBSThelper(ListNode head, int start, int end) {
        //too complicate need better implement, just record the postion
    	if (start > end) return null;
    	int med= start + (end-start)/2;
    	int i=0;
    	ListNode cur=head;
    	while (cur!=null& i< med) {
    		cur=cur.next;
    		i++;
    	}
    	TreeNode root= new TreeNode(cur.val);
    	TreeNode left=  listtoBSTThelper(head,start,mid-1);
    	TreeNode right = listtoBSThelper(head,mid+1,end);
    	root.left=left;
    	root.right=right;
    	return root;
    }
    	//problem java and C are different
       private TreeNode listtoBSThelper(ListNode head, int start, int end) {
    	if (start > end) return null;
    	int med= start + (end-start)/2;
    	TreeNode left=  listtoBSTThelper(head,start,mid-1);
    	TreeNode root= new TreeNode(head.val);
    	head=head.next;
    	TreeNode right = listtoBSThelper(head,mid+1,end);
    	root.left=left;
    	root.right=right;
    	return root;
    } 
}


public class Solution {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head==null ) {
        	return null;
        } 
        if (head.next==null) {
        	return new TreeNode(head.val);
        }
        int i = 0;
        ListNode temp = head;
        while (head !=null) {
        	head = head.next;
        	i++;
        }
        current=temp;
        return listtoBSThelper(0, i-1);
    }
       private TreeNode listtoBSThelper(int start, int end) {
    	if (start > end) return null;
    	int med= start + (end-start)/2;
    	TreeNode left=  listtoBSThelper(start,med-1);
    	TreeNode root= new TreeNode(current.val);
    	current=current.next;
    	TreeNode right = listtoBSThelper(med+1,end);
    	root.left=left;
    	root.right=right;
    	return root;
    } 
}