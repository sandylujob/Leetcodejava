/* Leetcode 91 Decode Ways
* A message containing letters from A-Z is being encoded to numbers using the following mapping:
*'A' -> 1
*'B' -> 2
*...
*'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
*/
//error. charAt need more time calcuate
//condtion s[i] = s[i-1] +s[i-2]
// i-1 is not '0'
// s[i-2.i-1] in [1,26]

public class Solution {
       public int numDecodings(String s) {
 				int len = s.length();
 				if (s == null || len == 0 || s.equals("0")) return 0;
 				int [] sum = new int[len+1];
 				sum[0] = 1;
 				if (isValid(s.substring(0,1))) {
 					sum[1] = 1;
 				} else {
 					sum[1] = 0;
 				}
   			
   			for (int i = 2 ; i<= len ; i++) {
   				if(isValid(s.substring(i-1,i))) {
   					sum[i] +=sum[i-1] ;
   				}

   				if (isValid(s.substring(i-2, i))) {
   					sum[i] +=sum[i-2];
   				}
   			}
   			return sum[len];
    }

    private boolean isValid(String s) {
    	if (s.charAt(0)=='0') {
    		return false;
    	}
    	int value = Integer.parseInt(s);
    	return value>=1&&value<=26;
    }
}