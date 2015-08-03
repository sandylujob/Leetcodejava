/*
* Leetcode 62 UniquePath
*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
*The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
*How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        if (m == 1 || n ==1) return 1;
        for (int i = 0; i< m-1; i++) {
        	res[i][n-1] = 1;
        }

        for (int i = 0; i < n-1; i++) {
        	res[m-1][i]= 1;
        }
        res[m-1][n-1] = 0;
        for (int i = m-2; i>=0 ; i--) {
        	for (int j = n-2; j>=0; j--) {
        		res[i][j] = res[i+1][j]+ res[i][j+1];
        	}
        }

        return res[0][0]; 
    }
}