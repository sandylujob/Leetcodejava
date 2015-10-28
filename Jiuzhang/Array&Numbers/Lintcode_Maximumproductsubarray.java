/* Leetcode 152 Maximum Product Subarray



Find the contiguous subarray within an array (containing at least one number) which has the largest product.

*/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums ==null) return 0;
        int m = nums.length;
        int[] local = new int[m];
        int[] global = new int[m];
        local[0]=global[0]=nums[0];
        for (int i=1 ; i< m; i++) {
        	if (local[i-1]>local[i-1]*nums[i]) {
        		if (nums[i]==0 ) {
        			local[i]=1;
        			continue;
        		} else {
        			local[i]=nums[i];
        			continue;
        		}
        	} else {
        		local[i]=local[i-1]*nums[i];
        	}
        	global[i]=Math.max(global[i-1],local[i]);
        }
        return global[m-1];
    }
}

// it is very hard to control the switch, consider 2 side > and <
// then min and max for switch.
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
          if (nums ==null) return 0;
        int m = nums.length;
        int[] max = new int[m];
        int[] min = new int[m];
        max[0]=min[0]=nums[0];
        int ret=nums[0];
        for (int i=1 ; i< m; i++) {
            min[i]=max[i]=nums[i];
          if (nums[i]>0) {
            min[i]=Math.min(min[i],min[i-1]*nums[i]);
            max[i]=Math.max(max[i],max[i-1]*nums[i]);
          } else if (nums[i]<0) {
              max[i]=Math.max(max[i],min[i-1]*nums[i]);
              min[i]=Math.min(min[i],max[i-1]*nums[i]);
          }
          ret=Math.max(ret,max[i]);
        }
        return ret;
    }
}

