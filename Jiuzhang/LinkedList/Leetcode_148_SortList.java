/* Leetcode 148 Sort List
Sort a linked list in O(n log n) time using constant space complexity.
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Pair {
	public ListNode first, second;
	public Pair (ListNode first, ListNode second) {
		this.first=first;
		this.second=second;
	}
}

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head ==null || head.next==null) return head;
        ListNode mid=findmid(head);
        Pair pair = Partition(head, mid.val);
        ListNode left=sortList(pair.first);
        ListNode right=sortList(pair.second);
        getTail(left).next=right;
        return left;
    }


    public ListNode findmid(ListNode head) {
    	ListNode slow=head, fast=head.next;
    	while (fast!=null && fast.next !=null) {
    		fast=fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }

    public Pair Partition(ListNode head, int x) {
    	ListNode dummy1 = new ListNode(-1);
    	ListNode dummy2 = new ListNode(-1);
    	ListNode dummy3 = new ListNode(-1);
    	ListNode temp1 = dummy1;
    	ListNode temp2 = dummy2;
    	ListNode temp3 = dummy3;
    	while (head !=null) {
    		if (head.val< x) {
    			temp1.next=head;
    			head = head.next;
    			temp1=temp1.next;
    		} else if (head.val > x ){
    			temp2.next=head;
    			head=head.next;
    			temp2=temp2.next;
    		} else {
    			temp3.next=head;
    			head=head.next;
    			temp3=temp3.next;
    		}
    	}
    	temp1.next=null;
    	temp2.next=null;
    	temp3.next=null;
    	// 3 list to 2 list 
    	if (dummy1.next ==null && dummy2.next ==null) {
    		ListNode mid=findmid(dummy3.next);
    		dummy1.next=dummy3.next;
    		dummy2.next=mid.next;
    		mid.next=null;
    	} else if (dummy1.next==null) {
    		dummy1.next= dummy3.next;
    	} else if (dummy2.next==null) {
    		dummy2.next= dummy3.next;
    	} else {
    	    ListNode temp = dummy2.next;
    	    dummy2.next=dummy3.next;
    	    getTail(dummy2.next).next=temp;	
    	}
    	return new Pair (dummy1.next, dummy2.next);
    }

    private ListNode getTail(ListNode head) {
    	if (head==null) { return null;}
    	while (head.next!=null) {
    		head=head.next;
    	}
    	return head;
    }
}