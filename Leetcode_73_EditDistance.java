/*
* leetcode 73 Edit Distance 
*Given two words word1 and word2, find the minimum number of steps required to convert word1
* to word2. (each operation is counted as 1 step.)
*
*You have the following 3 operations permitted on a word:
*
*a) Insert a character
*b) Delete a character
*c) Replace a character
*/
import java.lang.Math;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        if (0 == m) return word2.length();

        int n = word2.length();
        if (0 == n) return word1.length();
        int [][] result = new int [m+1][n+1] ;
        result[0][0]=0;

        for (int i = 1; i <= m; i++) {
            result[0][i] = i ;
        }

        for (int i = 1; i <= n; i++) {
            result[i][0] = i ;
        }

        int temp = 0 ;
        for (int i = 1; i<= m ; i++) {
        	for (int j = 1; j<= n ; j++) {
        		result[i][j] = Integer.MIN_VALUE;
                if ( word1.charAt(i-1) == word2.charAt(j-1) ) {
                    result[i][j] = result[i-1][j-1]
                }

                result[i][j] = Math.min(result[i][j], result[i-1][j-1]+1)
                //replace, matach three condtion
                result[i][j] = Math.min(result[i][j], Math.min(result[i-1][j], result[i],[j-1])+1);
        	}
        }
        return result[m][n];
    }
}