/* Leetcode 78 Subset
 Given a set of distinct integers, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

//要点 1。 No descending, 要排序
//         根据 S 的情况 用Arrays.sort or collections.sort
//2. recursive is as tree, []->[1]->[1,2]->[1,2,3]
//3. empty set count
//4. need new list cause old one is still change. need clone.
//5. leetcode now change to List 
//Recursive O(2^n)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>> ();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums); //No descending order
        subsethelper(result, temp, 0, nums);
        return result;
    }

    public void subsethelper(ArrayList<List<Integer>> result, List<Integer> list, int pos, int[] nums) {
    	result.add(new ArrayList<Integer> (list));
    	for (int i= pos; i < nums.length; i++) {
    		list.add(nums[i]);
    		subsethelper(resut, list, i+1, nums);
    		list.remove(list.size()-1);
    	}
    }
}

//no recusive
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>> ();
       	result.add (new ArrayList<Integer>());
       	if (nums ==null || nums.length ==0) return result;
       	Arrays.sort(nums);
       	for (int i=0; i<nums.length; i++) {
       		 int size= result.size();
       		 for (int j=0; j<size; j++) {
       		 	 ArrayList<Integer> item = new ArrayList<Integer> (result.get(j));
       		 	 item.add(nums[i]);
       		 	 result.add(item);
       		 }
       	}
    return retsult;
    }
}
