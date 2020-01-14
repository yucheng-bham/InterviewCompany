package interview.dynamicProgramming.LeetCode_152;

import javax.jws.soap.SOAPBinding;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,-2,4};
        int maxProduct = solution.maxProduct(nums);
        System.out.println(maxProduct);
    }
}
class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[] max = new int[n];
        max[0] = A[0];
        int[] min = new int[n];
        min[0] = A[0];
//         int maxhere = 0;
//         int minhere = 0;
         int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(A[i], Math.max(max[i - 1] * A[i], min[i - 1] * A[i]));
            min[i] = Math.min(A[i], Math.min(max[i - 1] * A[i], min[i - 1] * A[i]));
            res = Math.max(max[i], res);
        }
        return res;
    }
}
/*
class Solution{
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxtemp = 0;
        int mintemp = 0;
        int maxres = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            maxtemp = Math.max(min * nums[i], max * nums[i]);
            mintemp = Math.min(max * nums[i], min * nums[i]);
            max = Math.max(nums[i], maxtemp);
            min = Math.min(nums[i], mintemp);
            maxres = Math.max(max, maxres);
        }
        return maxres;
    }
}
*/

/*
class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;

        int max = Integer.MIN_VALUE, product = 1;
        // first go from left to right
        for (int i = 0; i < A.length; i++) {
            product *= A[i];
            if (product > max)
                max = product;
            if (product == 0)
                product = 1; // reset if encounter 0
        }

        // then go from right to left
        product = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            product *= A[i];
            if (product > max)
                max = product;
            if (product == 0)
                product = 1; // reset if encounter 0
        }

        return max;
    }
}
*/


