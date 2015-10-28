/* Leetcode 97 Interleaving String
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
             if (s1==null||s1.length()==0) return s2.equals(s3);
        if (s2==null||s2.length()==0) return s1.equals(s3);
        if (s3==null || s3.length()==0) return false;

        int m = s1.length();
        int n = s2.length();
        if (s3.length()!=m+n) {
        return false;
        }

        boolean[][] ret = new boolean[m+1][n+1];
        ret[0][0]=true;
        for (int i=1; i<= m; i++) {
        	if (s3.charAt(i-1)==s1.charAt(i-1)&&ret[i-1][0]) {
        		ret[i][0]=true;
        	}
        }

        for (int j=1; j<= n; j++) {
        	if (s3.charAt(j-1)==s2.charAt(j-1)&&ret[0][j-1]) {
        		ret[0][j]=true;
        	}
        }


        for (int i=1;i<=m; i++) {
        	for (int j=1;j<=n; j++) {
        		if (s1.charAt(i-1)==s3.charAt(i+j-1)&& ret[i-1][j]) {
        			ret[i][j]=true;
        		} else if (s2.charAt(j-1) ==s3.charAt(i+j-1)&&ret[i][j-1]) {
        			ret[i][j]=true;
        		}

        	}
        }
        return ret[m][n];
    }
}