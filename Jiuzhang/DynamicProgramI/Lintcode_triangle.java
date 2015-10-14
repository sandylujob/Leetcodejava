/* LintCode Triangle 
*/
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle==mull) return -1;
        if (triangle[0].length==null) return -1;
        int m = triangle.length;
        if (m==0) return -1;
        int n = triangle[m-1].length;
        if (n==0) return -1;
        if (m==1&&n==1) return triangle[0][0];
        int[][] result = new int[m][n];
         result[0][0]=triangle[0][0];
        for(int i= 1; i< m ; i++) {
        	result[i][0]=result[i-1][0]+triangle[i][0];
        	result[i][triangle[i].length-1]=result[i-1][triangle[i-1].length-1]+triangle[i][triangle[i].length-1];
        }

        for (int i = 1; i< m ; i++) {
        	for (int j = 1; j<triangle[i].length-1; j++) {
        		result[i][j]=Math.min(result[i-1][j], result[i-1][j-1])+triangle[i][j];

        	}
        }
        int sum = result[m-1][0];
        for (int j = 1; j < result[j-1].length; j++) {
            if (result[m-1][j] < sum) {
                sum = result[m-1][j];
            }
        }
        return sum ;
    }
}

