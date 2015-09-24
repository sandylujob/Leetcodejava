/*
* Leetcode 44 Wilcard Matching
*Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

//recursive soluction
// Time limited exceed
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0 ) return s.length() == 0;
        if (p.length() == 1) {
        	return ((s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='?'))|| p.charAt(0)=='*');
        }
        if (p.charAt(0)=='*') {
        	while (p.charAt(0)=='*') {
        		p.substring(1);
        	}
        	if (p.length()==0) {return true;}
        	while (s.length()>0 && isMatch(s,p)) {
        		s.substring(1);
        	}
        	return s.length() !=0;
        } else if (p.charAt(0)==s.charAt(0) || p.charAt(0) =='?') {
        	return isMatch(s.substring(1), p.substring(1));
        } else {
        	return false ;
        }
    }

 //soluction 2
  /*anaylsis
  *  ret[j][i]  s : j-1 , p i-1 charactre match
  *  start point :
  *   ret[0][0] = 1, k-1 == '*',' ret [0][k] = ret[0][k-1]
  *   ret[j][i], if i-1 !='*' , ret[j-1][i-1] && s[j-1]==p[j-1] || p[j-1]=='?'
  *              else ii-1 =='*' check 0,1,...n condition.
  *              if ret[j][i-1] (0) || ret[j-1][i-1] , then all ret[j+1,j+2,.......m][i]=true
  *  edge case:  p.length =0 and p.length = 1
  */  
    public boolean isMatch(String s, String p) {
   	if (p.length() ==0) {
    		return s.length() == 0;
    	}
    	if ( p.length() ==1 ) {
    		return ((s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='?'))|| p.charAt(0)=='*');
    	}

    	boolean [][] ret = new boolean[s.length()+1][p.length()+1];
    	ret[0][0] = true;
    	for (int i=1 ; i<= p.length() ; i++) {
    		 if (p.charAt(i-1) == '*') {
    		 	 ret[0][i] = ret[0][i-1] ;
    		 }
    	}

    	for (int j=1 ; j<= s.length() ; j++) {
    		for (int i=1; i<= p.length(); i++) 
    		{  
    			if (p.charAt(i-1) !='*') {
    				ret[j][i] = ret[j-1][i-1] && (s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?');
    			}
    			else {
    				if (ret[j-1][i-1]||ret[j][i-1]) {
    					ret[j][i] = true ; 
    				for (int m=j+1; m<= s.length(); m++) {
    					ret[m][i] = true;
    				} }
    			}
    		}
    	}
    	return ret[s.length()][p.length()];
    }

}
