/* 74 Search a 2D Matrix
*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
*/

//problem edge check, mainly for matrix[0]==null.

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
       	if (matrix == null|| matrix.length ==0 ) {return false; }
       	if (matrix[0] == null || matrix[0].length == 0) 
       	{return false; }
        int m = matrix[0].length;
        int n = matrix.length;
        int end = m * n - 1;
        int start = 0;
        int mid;
        int row,col;
        while (start + 1 < end) {
        	mid = start + (end - start)/2;
        	int temp = matrix[mid/m][mid%m];
        	if ( temp ==target) {
        			return true;
        	} else if (temp>target) {
        		 end = mid;
        	} else {
        		 start = mid;
        	}
        }
	if (matrix[start/m][start%m]== target) {
        			return true;
        	}
        	if (matrix[end/m][end%m]==target) {
        			return true;
        	}
    return false;
    }
}