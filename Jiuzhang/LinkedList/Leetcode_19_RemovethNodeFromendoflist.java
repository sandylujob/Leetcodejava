//* Leetcode 19 Remove Nth Node From End of List
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   */
   /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // bug consider clear whihch point is the order
  public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
           if (head==null) return head;
        ListNode dump = new ListNode(-1);
        dump.next=head;
        head = dump;
        ListNode t1 = dump;
        //bug use n and n--.
        int p=n;
        while ( p>0 && t1.next!=null) {
        	p--; t1=t1.next;
        } 
        if ( p>0 &&t1.next==null) return null;

        while (t1.next !=null) {
        	t1=t1.next;
        	head=head.next;
        }
        head.next=head.next.next;
        return dump.next;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
