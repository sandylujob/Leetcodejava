/* Leetcode 115 Distinct Subsequences
 Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3. 

*/
// hard to for f[i][j] , xxxxa xxxxxa -> i==j, f[i][j]== f[i-1][j-1] + f[i-1][j] ;
 //             i !=j f[i-1][j] 
//draw the graph
public class Solution {
    public int numDistinct(String s, String t) {
 
         if (s==null || s.length()==0) return 0;
        //bug 1. more )
        if (t==null || t.length()==0) return 0;

        int m = s.length();
        int n = t.length();
        int[][] ret = new int[m+1][n+1];
        //bug 2 i=1; from the chart [0][0]=1;
        for (int i = 0; i<=m; i++) {
        	ret[i][0]=1;
        }
        for (int j = 1; j<=n; j++) {
        	ret[0][j]=0;
        }

        for (int i= 1; i<=m ; i++) {
        	for (int j= 1; j<=n ; j++) {
        		ret[i][j] = ret[i-1][j];
        		if (s.charAt(i-1)==t.charAt(j-1)) {
        			ret[i][j] +=ret[i-1][j-1];
        		} 
        	}
        }
        return ret[m][n];
    }
}