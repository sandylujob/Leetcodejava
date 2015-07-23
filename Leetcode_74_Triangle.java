/**
*Leetcode 74 
* Given a triangle, find the minimum path sum from top to bottom. 
* Each step you may move to adjacent numbers to the row below
*/
import java.lang.Math;
public class Solution {
	 public int minimumTotal(List<List<Integer>> triangle) {
	 	if (0==triangle.size() ) return 0;
	 	int col = triangle.size()
	 	List<Integer> temp = new List<Integer>() ;
	 	temp = triangle.get(col-1);
	 	int row = temp.size();
	 	int[] result = new int[row];	 	
	 	List<Integer> temp = new List<Integer>() ;
	 	for (int i = 1; i< triangle.size(); i++) {
	 		temp = triangle.get(i);
	 		for (int j = temp.size()-1; j >= 0; j--) {
	 			if (j == 0) {
	 				result[j]= result[j]+temp.get(j);
	 			} else if ( j == temp.size()-1 ) {
	 				result[j] = result[j] +temp.get(j);
	 			} else {
	 				result[j] = Math.min(result[j-1], temp.get[j]+result[j]);
	 			}
	 		}
	 	}

	 	int ret = Integer.MAX_VALUE;
	 	for (int i = 0 ; i < row ; i++) {
	 		ret = Math.min(ret, result[i]);
	 	} 

	 	return ret;
	}
}
