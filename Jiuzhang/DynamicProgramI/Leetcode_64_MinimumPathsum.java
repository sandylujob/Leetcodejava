/*Leetcode 64 Minimum Path Sum 
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        if (n==0) return 0;
        if (m==1&&n==1) return grid[0][0];
        int[][] result = new int[m][n];
        result[0][0]=grid[0][0];
        for (int i = 1; i < m ; i++) {
        	result[i][0]=result[i-1][0]+grid[i][0];
        }

        for (int j = 1; j < n ; j++) {
        	result[0][j]=result[0][j-1]+grid[0][j];
        }

        for (int i = 1; i < m ; i++) {
        		for (int j = 1; j < n ; j++) {
        		 result[i][j]=Math.min(result[i-1][j], result[i][j-1])+grid[i][j];
        		}
        }
        return result[m-1][n-1];
    }
}