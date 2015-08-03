/*
* Leetcode 63 UniquePath II
*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
*The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
*How many possible unique paths are there?
*
*Follow up for "Unique Paths":
*Now consider if some obstacles are added to the grids. How many unique paths would there be?
*An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if ( m == 0  ) return 0;
        int n = obstacleGrid[0].length;
        if ( n == 0) return 0;
        int [][] result = new int[m][n];
        boolean flag = true；
        for (int i = 0; i < m ; i++) {
        { if (obstacleGrid[i][0] == 1)
        		result[i][0] = 0 ;
        		flag = false ; }
        	else if (!flag) {
        		result[i][0] = 0;
        	} else {
        		result[i][0] = 1 ;
        	}
        }
        flag = true ;
         for (int i = 0; i < n ; i++) {
        { if (obstacleGrid[0][n] == 1)
        		result[0][n] = 0 ;
        		flag = false ; }
        	else if (!flag) {
        		result[0][i] = 0;
        	} else {
        		result[0][i] = 1 ;
        	}
        }

        for (int i = 1; i < m ; i++) { 
        	for (int j = 1; j < n ; j++) { 
        		if (obstacleGrid[i][j] == 1) {
        			result[i][j] = 0;
        		}
        		else {
        			result[i][j] = result[i-1][j] +result[i][j-1] ;
        		}
        }
     } 
     return result[m-1][n-1];  		
    }
}