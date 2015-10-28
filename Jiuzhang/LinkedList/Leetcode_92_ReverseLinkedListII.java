/* Leetcode 92 Reverse Linked List II
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) {
        	return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode temp = dummy;

        //here the index should be 1 for start, get pre
        int index=1;
        while (index<m && temp !=null) {
        	temp=temp.next;
        	index++;
        }
        // need 3 index 1 float index
        //beware increase the index
      	ListNode preNode = temp;
      	ListNode mNode = temp.next;
      	ListNode dummy2 = null;
      	ListNode nNode=mNode;
      	while (nNode !=null && index<=n) {
      		ListNode temp2=nNode.next;
      		nNode.next=dummy2;
      		dummy2=nNode;
      		nNode =temp2;
      		index++;
      	}
      	preNode.next=dummy2;
      	mNode.next=nNode;
      	return dummy.next;
    }
}