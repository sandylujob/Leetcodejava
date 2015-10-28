/* Leetcode 82 Remove duplicated from sorted list II
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
 		if (head == null || head.next==null ) return head;  
 		ListNode dummy = new ListNode(-1);
 		dummy.next=head;
 		ListNdoe pre = head;
 		while (head !=null) {
 		//null pointexception should not use head.next as //consider
 		//	if (head.val==head.next.val) {
 			
 				int cur = head.val;
 				while (head.val==cur) {
 					head=head.next;
 				}
 				pre.next=head;
 			} 
 			if (head !=null)
 			{head=head.next;}
 		}
 		return dummy.next;
    }

    //problem solved sorted list I
     public ListNode deleteDuplicates(ListNode head) {
 		if (head == null || head.next==null ) return head;  
 		ListNode dummy = new ListNode(-1);
 		dummy.next=head;
 		ListNdoe pre = head;
 		while (head !=null) {
 			if (pre.val !=head.val) {
 				head=head.next;
 				pre=head;
 			} else {
 				head =head.next;
 				while (head!=null&&pre.val==head.val) {
 					head=head.next;
 				}
 				prev.next=head;
 			}
 		}
 		return dummy.next;
    }

 public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
     	if (head == null || head.next==null ) return head;  
 		ListNode dummy = new ListNode(-1);
 		dummy.next=head;
 		ListNode pre = dummy;
 		while (head !=null&&head.next!=null) {
 			 if (head.val==head.next.val) {
 			 	int cur = head.val;
 			 	while (head !=null && head.val==cur) {
 			 		head = head.next;
 			 	}
 			 	pre.next=head;
 			 } else {
 			 //bug pre should be head of head;
 			     pre = head;
 			 	head = head.next;
 
 			 }
 			}	return dummy.next;
 		}


 }