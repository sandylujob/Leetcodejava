/* Leetcode 23  Merge K sorted List

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null) return null;
        if (lists.length==1) return lists[0];
        int p = lists.length;
        return mergerheper(lists, 0, p-1); 
    }

    public  ListNode mergerheper (ListNode[] lists, int start, int end) {
    	//bug all condition should be consider
    	// null, one list and two list
        if (start > end) return null;
        if (start==end ) return lists[start];
    	if ((end-start)==1) {
    	  return merge2List(lists[start],lists[end]);
    	}
    	int mid=start+(end-start)/2;
    	ListNode left=mergerheper(lists,start,mid);
    	ListNode right=mergerheper(lists,mid+1,end);
  		return merge2List(left,right);
    }
    public ListNode merge2List(ListNode list1, ListNode list2) {
    	if (list1 == null) return list2;
    	if (list2 == null) return list1;
    	ListNode dummy = new ListNode(-1);
    	ListNode head= dummy;
    	while (list1 !=null && list2 !=null) {
    		if (list1.val <=list2.val) {
    			head.next=list1;
    			list1=list1.next;
    			head=head.next;
    		} else {
    			head.next=list2;
    			list2=list2.next;
    			head=head.next;
    		}
    	}
    	if (list1 !=null) {
    		head.next=list1;
    	}else if (list2 !=null) {
    		head.next=list2;
    	}
    	return dummy.next;
    }
}