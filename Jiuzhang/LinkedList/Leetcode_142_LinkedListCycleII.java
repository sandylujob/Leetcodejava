/* Leetcode 142 Linked List Cycle II
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null ;
       
        boolean cycle=false;
        ListNode slow=head;
        //findmid, fast only one ahead
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null) {
        	if (fast==slow) {
        		cycle = true;
        		break;
        	}
        	fast=fast.next.next;
        	slow=slow.next
        }
        if (!cycle) return null;
    	while (head !=slow) {
    		head = head.next;
    		slow=slow.next;
    	}
    	return head;
    }

     public ListNode detectCycle(ListNode head) {
     	 if (head==null || head.next==null) return null ;
     	 boolean cycle=false;
     	 ListNode slow=head;
     	 ListNode fast=head;
     	 while (fast!=null && fast.next!=null) {
     	 	fast=fast.next.next;
     	 	slow=slow.next;
     	 	if (fast==slow) {
     	 		cycle = true;
     	 		break;
     	 	}
     	 }
     	 if (!cycle) { return null;}
     	 slow=head;
     	 while (slow != fast) {
     	 	slow =slow.next;
     	 	fast=fast.next;
     	 }
     	 return slow;
     } 
}