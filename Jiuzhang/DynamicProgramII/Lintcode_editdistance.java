/* lintcode Edit distance
*
*/
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
    	if (word1==null || word1.length()==0) return word2.length();
    	if (word2==null || word2.length()==0) return word1.length();

    	int m = word1.length();
    	int n = word2.length();

    	int[][] ret = new int[m+1][n+1];
    	ret[0][0] = 0;
    	
    	for (int i=1; i<=m; i++) {
    		ret[i][0]=i ;
    	}

    	for (int j=1; j<=n; j++) {
    		ret[0][j]=j;
    	}

    	for (int i= 1 ; i<= m ; i++) {
    		for (int j= 1 ; j<=n ; j++) {
    			ret[i][j]= Integer.MAX_VALUE;
    			if (word1.charAt(i-1)==word2.charAt(j-1)) {
    				ret[i][j] = ret[i-1][j-1];
    			} 
    			
    			ret[i][j]=Math.min(ret[i-1][j-1] +1 ,ret[i][j]);

    			ret[i][j]=Math.min(ret[i][j], Math.min(ret[i][j-1],ret[i-1][j])+1);
    		}
    	} return ret[m][n];
    }
    
}
