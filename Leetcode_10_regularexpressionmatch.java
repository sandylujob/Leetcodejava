/*
* Leetcode 10 regular expression matching
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

*/
//DP soluction
//Problem more details on DP
//DP analysis
// ret[i][j], substring s[0,i) == p[0,j)		
// ret[0][0] = true
// ret[0][j] = true while p[j-1] = '*' and ret[0][j-2] = true
// ret[i][0] = false
// condition :
// p[j-1] != '*'
// i >0 and j> 0 
// ret[i][j] = ret[i-1][j-1] with s[i-1]==p[j-1] or p[j-1] = '.'
// p[j-1]='*'(not the first one) j> 1
// 1. 0 character,  ret[i][j] = ret[i][j-2]
// 2. 1 character ret[i][j]= ret[i-1][j-2] s[i-1]==p[j-2]
// 3. any character ret[i][j] = ret[i-1][j], s[i-1]==p[j-2]
//simplity:
//1 to N, ret[i][j] = ret[i-1][j] 
public class Solution {
public boolean isMatch(String s, String p) {
		int lens = s.length();
		int lenp = p.length();

		boolean[][] ret = new boolean[lens + 1][lenp + 1];
		ret[0][0] = true;
		  for (int j = 2; j<=lenp; j++) {
	            if ((p.charAt(j-1)=='*') && ret[0][j-2] )
	            ret[0][j]=true;
	        }
		
		for (int i = 0; i <= lens; i++) {
			for (int j = 0; j <= lenp; j++) {
				if (i > lens && j > lenp) {
					continue;
				}
				if (j > 1) {
					if (ret[i][j - 2] && p.charAt(j - 1) == '*') {
						ret[i][j] = true;
					} }
					if (i > 0 && j > 0) {
						if (ret[i - 1][j - 1]
								&& match(s.charAt(i - 1), p.charAt(j - 1))) {
							ret[i][j] = true;
						}
						
					}
					if (i > 0 && j > 1) {
						 if (ret[i-1][j] && p.charAt(j-1) == '*' && match(s.charAt(i - 1), p.charAt(j - 2))){
				    		 ret[i][j] = true;
				    	 } 
					}
			  
			}
		}
		return ret[lens][lenp];
	}

	public boolean match(char x, char y) {
		return x == y || y == '.';
	}
}

//Greedy Wrong ones
public class Solution2 {
	public boolean isMatch(String s, String p) {
		return tryMatch(s,p,0,0);
	}

	public boolean tryMatch(String s, String p , int spointer, int ppointer) {
		if (ppointer == p.length()-1) return spointer == s.length()-1;
		if (p.charAt(ppointer+1) != '*') {
			if (p.charAt(ppointer)==s.charAt(spointer) || (p.charAt(ppointer)=='.' && spointer < s.length()))
				return tryMatch(s,p,spointer+1, ppointer+1);
			return false;
		} else {
			while (p.charAt(ppointer)==s.charAt(spointer)||(p.charAt(ppointer)=='.' && spointer < s.length())) {
				if tryMatch(s,p,spointer,ppointer+2)  return true;
				spointer++;
			}
			return tryMatch(s,p,spointer,ppointer+2);
		}
	} 
}

//consider condtion in more detailed
public class Solution3 {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) return  { s.length() == 0; }
		//special case
		if (p.length()==1 ) 
			 { return s.length() ==1 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0)) ;
		}	
		// case secon one not '*'
		if (p.charAt(1) != '*') {
			if (s.length() < 1 ) {
				return false;
			}

			if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.' ) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		else {
			if (isMatch(s, p.substring(2))) {
				return true;
			} 
			/* when '*' stand for 1 or more need prune  */
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i+1),p.substring(2))) {
					return true;
				}
				i++;	
			}
			return false;
		}

	} 
}