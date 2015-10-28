/*Lintcode Longest Common Subsequence
Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.
Have you met this question in a real interview?
Example

For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.
*/
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if ( A==null || A.length()==0) return 0;
        if (B==null || B.length()==0) return 0;

       int m= A.length();
       int n= B.length();

       int[][] ret = new int[m+1][n+1];
       ret[0][0]=0;
       for (int i=1; i<=m; i++) {
       	for (int j=1; j<=n; j++) {
       		if (A.charAt(i-1)==B.charAt(j-1)) {
       			ret[i][j]=ret[i-1][j-1]+1;
       		} else {
       			ret[i][j]=Math.max(ret[i-1][j],ret[i][j-1]);
       		}
       	}
       }

       return ret[m][n];
    }
}

