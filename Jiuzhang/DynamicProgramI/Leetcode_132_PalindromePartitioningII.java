/* leetcode 132 Palindrome Partitioning II
*
 Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
*/
// consider max cut on condtion.
public class Solution {
      public int minCut(String s) {
         if (s==null || s.length()==0) return 0 ;
         int strlen = s.length();
         boolean [][] isPalindrome = getispalindrome(s);
         int[] ret = new int[strlen+1];
         
         for (int i= 0; i<= s.length(); i++) {
         		ret[i]= i-1;
         }

         for (int i=1; i<=strlen; i++) {
         		for (int j=0; j<i ; j++) {
         			if (isPalindrome[j][i-1]) {
         				ret[i] = Math.min(ret[i], ret[j]+1);
         			}
         		}
         }
         return ret[strlen];
    }

    private boolean ispalindrome(String s) {
    	int start = 0;
    	int end = s.length()-1;

    	while (start < end) {
    		if (s.charAt(start)==s.charAt(end)) {
    			start++;
    			end--;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }

    private boolean[][] getispalindrome(String s) {
    	boolean[][] list = new boolean[s.length()][s.length()];

    	for (int i=0; i< s.length(); i++) {
    		list[i][i]=true;
    	}

    	for (int i=0; i< s.length()-1; i++) {
    		list[i][i+1] = (s.charAt(i)==s.charAt(i+1));
    	}

    	for (int length = 2 ; length< s.length(); length++) {
    		for (int i= 0; i+ length < s.length(); i++ ) {
    			list[i][i+length] = list[i+1][i+length-1] && (s.charAt(i)== s.charAt(i+length));
    		}
    	}
    	return list;
    }
}