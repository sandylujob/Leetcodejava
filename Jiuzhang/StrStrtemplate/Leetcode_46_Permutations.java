/* Leetcode 44  Permutations
* 
Given a collection of numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
*/

/**
 * Problem: How to make it as Permutation according to combination? 
 * -- don't use position as start marker. Help only has three parameters. 
 * 
 * Every time we can get other element from whole int[],start from 0, so i=0, just need to remove duplicate  
 * 
 * if list.size() == num.length, we add a result and return, Actually, remove return; will not have influence on final result. 
 * the program will slow because it will enter following loop until go out.
 * (Every time it contains, and continue because of full of different elements stored already)
 * 
 * In addition, we remove Arrays.sort(num) because permutation don't care non-descending order.
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(nums,temp,ret);
        return ret;
    }

    public void helper(int[] nums, List<Integer> list, ArrayList<List<Integer>> ret) {
    	if (list.size() == nums.length) {
   				ret.add(new ArrayList<Integer> (list));
   				return;
    	} 
    	for (int i=0; i<nums.length; i++) {
    			if (list.contains(nums[i])) {
    				continue;
    			}
    			list.add(nums[i]);
    			helper(nums,list,ret);
    			list.remove(list.size()-1);
    		}
    }
}


public class Solution {
     public ArrayList<ArrayList<Integer>> permute(int[] nums) {
     	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
     	if (nums== Null || nums.length ==0) return ret;
     	ArrayList<Integer> temp = new ArrayList<Integer>();
     	first.add(nums[0]);
     	res.add(first);
     	for (int i = 1; i<nums.length; i++) {
     		 ArrayList<ArrayList<Integer>> newret= new ArrayList<ArrayList<Integer>>();
     		 for (int j=0; j<res.size(); j++) {
     		 		ArrayList<Integer> cur = res.get(j);
     		 		for (int k=0; k<cur.size(); k++) {
     		 			ArrayList<Integer> item = new ArrayList<Integer> (cur);
     		 			item.add(k,nums[i]);
     		 			newret.add(item);
     		 		}
     		 }
     		res=newret;
     	}
     return res;	
     }



}