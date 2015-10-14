/*Leecode 63 Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

Note: m and n will be at most 100.
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	if (m == 0) return 0;
    	int n = obstacleGrid[0].length;
    	if (n == 0) return 0;

    	int[][] result = new int[m][n];

    	for (int i = 0; i < m ; i++) {
    		if (obstacleGrid[i][0] !=1) {
    		 result[i][0] =1;
    		} else {
    			break;
    		}
    	}

     for (int j = 0; j < n ; j++) {
    		if (obstacleGrid[0][j] !=1) {
    				result[0][j] = 1;
    			} else {
    			 break;
    			}
    	}

    	for (int i = 1; i< m ; i++) {
    		for (int j = 1; j< n ; j++) {
    			if (obstacleGrid[i][j] == 1) {
    				result[i][j] = 0;
    			}
    			else {
    				result[i][j] = result[i-1][j] + result[i][j-1];
    			}
    		}
    	}
    	return result[m-1][n-1];
    }
}