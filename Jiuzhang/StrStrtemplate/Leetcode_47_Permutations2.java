/* Leetcode 47  Permutations II
* 
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
*/
/*
* visited for control
* visited[i] || i>0, nums[i]=nums[i-1], visited[i-1]=false
*/

public class Solution {
     public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums,visited,temp,ret);
        return ret;
    }

    public void helper(int[] nums, boolean[] visited, List<Integer> list, ArrayList<List<Integer>> ret) {
    	if (list.size()==nums.length) {
    		ret.add(new ArrayList<Integer>(list)); 
    		return;
    	}
    	for (int i=0; i<nums.length; i++) {
    		if (visited[i] || (i>0 && nums[i]==nums[i-1] && visited[i-1]==false)) {
    			continue;
    		}
    		visited[i]=true;
    		list.add(nums[i]);
    		helper(nums,visited,list,ret);
    		list.remove(list.size()-1);
    		visited[i]=false;
    	}
    }
}