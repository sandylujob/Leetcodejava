/* Lintcode Longest Common Substring

Given two strings, find the longest common substring.

Return the length of it.
Have you met this question in a real interview?
Example

Given A = "ABCD", B = "CBCE", return 2.
Note

The characters in substring should occur continuously in original string. This is different with subsequence.
Challenge

O(n x m) time and memory.
*/
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if ( A==null || A.length()==0) return 0;
        if (B==null || B.length()==0) return 0;

       	int n = A.length();
		int m = B.length();
		int f[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1] + 1;
				} else {
					f[i][j] = 0;
				}
			}
		}
		//bug should check all condtion.since the define
		//is only for how many number of folder
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				max = (max < f[i][j]) ? f[i][j] : max;
			
			}
			
		}
		return max;
    }
}
