/* leetcode 139 Word Break
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
*/

// problem *
// how to decide array space,
// a[i]  i length substring can be separated.
// substring is [j,i),
//need to 
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
      if (s==null || s.length() ==0) return false;
        if (wordDict ==null) return false;
        int m = s.length();
        boolean[] ret= new boolean[m+1];
        ret[0]= true;
        for (int i = 1; i<= m ; i++) {
        	for (int j=0; j< i; j++) {
        		if (ret[j] && wordDict.contains(s.substring(j,i))) {
        			ret[i] = true;
        			break; 
        		}
        	}
        }
        return ret[m];
    }
}

// if wordDict is too big version
//error version wordlen can't check all if maxlen=maxlen
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
    if (s==null || s.length() ==0) return true;
		 if (dict ==null) return false;
		 int maxlen = getmaxlen(dict);
		 int m = s.length();
		  boolean[] ret= new boolean[m+1];
       ret[0]= true;
       for (int i = 1; i<= m ; i++) {
       		//for (int wordlen = 0; wordlen<=maxlen-1 && wordlen< i; wordlen++ ) {
       	  for (int wordlen = 1; wordlen<=maxlen && wordlen<= i; wordlen++ ) {
       				if (!ret[i-wordlen]) {
       					continue;
       				}
       				if (dict.contains(s.substring(i-wordlen,i))) {
								ret[i] = true;
								break ;
						}
       		}
       }
       return ret[m];
    }
    private int getmaxlen(Set<String> dict) {
		int maxlen = 0;
		for (String word : dict) {
				maxlen = Math.max(maxlen, word.length());
		}
		return maxlen;
	}
}