/* Leetcode 90 SubsetII
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetheper(0,nums,temp,result);
        return result; 
    }

    public void subsetheper(int pos, int[] nums, List<Integer> list, List<List<Integer>> result) {
      result.add(new ArrayList<Integer>(list));
      for (int i=pos; i<nums.length; i++) {
        if ( i!=pos && nums[i] == nums[i-1]) {
          continue;
        }
        list.add(nums[i]);
        subsetheper(i+1,nums,list,result);
        list.remove(list.size()-1);
      }
    }
}