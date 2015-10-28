/* LintCode Subarray Sum

Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
Example

Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
Note

There is at least one subarray that it's sum equals to zero
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     //time exceed O(n2)
    public ArrayList<Integer> subarraySum(int[] nums) {
         if (nums.length ==0 ) return new ArrayList<Integer>();
        int[] sum=new int[nums.length+1];
        sum[0]=0;
        for (int i=1;i<=nums.length; i++) {
        //bug 1 nums should also be i-1
        	sum[i]=sum[i-1]+nums[i-1];
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        for (int i=1; i<=nums.length; i++) {
        	for (int j=0; j<i; j++) {
        		if (sum[i]-sum[j]==0) {
        			result.add(j);
        			//result should be 1 less
        			result.add(i-1);
        			return result;
        		}
        	}
        }
        return result;
    }

    // use hashmap for compare more quick.
    public ArrayList<Integer> subarraySum(int[] nums) {
	if (nums.length ==0 ) return new ArrayList<Integer>();

    	int len=nums.length;
    	ArrayList<Integer> result=new ArrayList<Integer>();
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	map.put(0,-1);
    	int sum=0;
    	for (int i=0; i<len; i++) {
    		sum +=nums[i];
    		if (map.containsKey(sum)) {
    			result.add(map.get(sum)+1);
    			result.add(i);
    			return result;
    		}
    		map.put(sum,i);
    	}
    	return result;
    }
}


}