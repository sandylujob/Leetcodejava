/* Leetcode 86 Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
public class Solution {
    public ListNode partition(ListNode head, int x) {
          if (head==null || head.next==null) return head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode t1 = dummy1;
        ListNode t2= dummy2;
        while (head !=null) {
        	if (head.val < x )
        	{
        		t1.next=head;
        		head = head.next;
        		t1=t1.next;
        	} else {
        		t2.next=head;
        		head = head.next;
        		t2=t2.next;
        	}
        }
        t1.next=dummy2.next;
        //bug add t2 point to null
        t2.next=null;
        return dummy1.next;
    }
}
}

