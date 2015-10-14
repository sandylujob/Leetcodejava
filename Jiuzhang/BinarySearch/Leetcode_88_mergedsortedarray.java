/* Leetcode 88  merged sorted Array
*Given two sorted integer arrays nums1 and nums2, 
*merge nums2 into nums1 as one sorted array.
*/
// in-place happened better for the end. not from start
//

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( n==0 ) 
        	 {return;}
        else if ( m==0 ) {
        	for (int i=0;i<n; i++) {
        		nums1[i]=nums2[i];
        	}
        	return;
        }
      int pos1=m-1;
      int pos2=n-1;
      int fpos=m+n-1;
      while (pos1>=0 && pos2>=0) {
      	if(nums1[pos1]>= nums2[pos2]) {
      		nums1[fpos]=nums1[pos1];
      		fpos--;
      		pos1--;
      	} else {
      		nums1[fpos]=nums2[pos2];
      		fpos--;
      		pos2--;
      	}
      }

      if (pos1>=0) {
      	for (int i=pos1; i>=0; i--) {
      		nums1[fpos]=nums1[i];
      		fpos--;
      	}
      } 
      if (pos2>=0) {
      	for (int i=pos2; i>=0; i--) {
      		nums1[fpos]=nums2[i];
      		fpos--;
      	}
      }        
    }
}
