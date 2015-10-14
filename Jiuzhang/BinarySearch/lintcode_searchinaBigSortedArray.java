/* lintcode Search in a Big Sorted Array
 Given a big sorted array, find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.
Have you met this question in a real interview?
Example

Given [1, 3, 6, 9, 21], and target = 3, return 1.

Given [1, 3, 6, 9, 21], and target = 4, return -1.
Challenge

O(log k), k is the first index of the given target number.
*/

//consider duplicate 
public class Solution {
    /**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(int[] A, int target) {
        // write your code here
        if (A==null || A.length == 0 ) 
            {return -1; }
        if (A.length==1) 
        		{ return (A[0]==target) ? 0: -1; }
        int pos = 0
        while (A[pos]<target) {
        	 pos = pos * 2 + 1;
        }

        int start = 0;
        int end = pos;
        int mid;
        while (start + 1 < end) {
        		mid = start + (end - start) / 2;
        		} else if ( A[mid] >= target) {
        			end = mid;
        		} else {
        			start = mid ;
        		}
        }

        if (A[start] == target) {
        	return start;
        }
       if (A[end] == target) {
        	return end;
        }

      return -1;
    }
}
