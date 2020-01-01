package interview.dynamicProgramming.LeetCode_53;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}