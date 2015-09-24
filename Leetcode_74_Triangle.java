/**
*Leetcode 74 
* Given a triangle, find the minimum path sum from top to bottom. 
* Each step you may move to adjacent numbers to the row below
*/
import java.lang.Math;
public class Solution {
	//Top Down  O(n^2) , space O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
	if (0==triangle.size() ) return 0;
	 	int col = triangle.size();
	 	List<Integer> temp = new ArrayList<Integer>() ;
	 	temp = triangle.get(col-1);
	 	int row = temp.size();
	 	int[] result = new int[row];
	 	result[0]=triangle.get(0).get(0);
	 	for (int i = 1; i< triangle.size(); i++) {
	 		temp = triangle.get(i);
	 		for (int j = temp.size()-1; j >= 0; j--) {
	 			if (j == 0) {
	 				result[j]= result[j]+temp.get(j);
	 			} else if ( j == temp.size()-1 ) {
	 				result[j] = result[j-1] +temp.get(j);
	 			} else {
	 				result[j] = Math.min(result[j-1], result[j])+ temp.get(j);
	 			}
	 		}
	 	}

	 	int ret = Integer.MAX_VALUE;
	 	for (int i = 0 ; i < row ; i++) {
	 		ret = Math.min(ret, result[i]);
	 	} 

	 	return ret;
    }

    //Bottom Up
    public int minimumTotal(List<List<Integer>> triangle) {
    	if ( 0 == triangle.size()) return 0;
    	if (1 == triangle.size() ) return triangle.get(0).get(0);
    	int [] result = new int [triangle.size()];

    	for (int i = 0; i< triangle.size() ; i++) {
    		result[i] = triangle.get(triangle.size()-1).get(i);
    	}

    	for ( int i = triangle.size()-2 ; i>= 0; i--) {
    		for (int j = 0 ; j< = i ; j++) {
    			result[j] = Math.min( result[j],result[j+1]) + triangle.get(i).get(j);
    		}
    	}

    	return result[0];
    }
}