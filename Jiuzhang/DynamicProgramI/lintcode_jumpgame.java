/* lintcode jump game


public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null) return false;
        if (A.length==0) return false;
        int m = A.length;
        boolean[] ret= new boolean[m];
        ret[0]=true; 
        for (int i = 1; i< m ; i++) {
        	for (int j= 0; j<i ; j++) {
        		if (ret[j] && A[j]>= i-j) {
        			 ret[i] = true;
        			 break;
        		}
        	}
        }
        return ret[m-1];
        
    }
}

