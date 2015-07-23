/**
*Leetcode 85 
* maximal 2D rectangle with all 1;
*/

import java.lang.Math; //Leetcode 85

public class Solution {
   public int maximalRectangle(char[][] matrix) {
	int col = matrix.length;
	if ( 0 == col ) {
		return 0;
	}
	int row = matrix[0].length;

	int [] H = new int[row];
	int [] R = new int[row];
	int [] L = new int[row];

	Arrays.fill(R,row);

	int maxRect = 0;

	for (int i=0; i<col; i++) {
		int left =0 ;
		int right = row ;

		for (int j=0; j<row; j++) {
			if (matrix[i][j]=='1') {
				H[j]++ ;
				L[j] = Math.max(L[j], left);
			} else {
				H[j] = 0;
				left = j + 1;
				L[j] = 0;
				R[j] = row;
			}
		}
		for (int j=row-1 ; j>= 0; j--) {
			if (matrix[i][j]=='1') {
				R[j] = Math.min(R[j], right) ;
				maxRect = Math.max(maxRect, H[j]*(R[j]-L[j])) ;

			} else {
				right = j;
			}
		}
	}
return maxRect;
}
}