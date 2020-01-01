package interview.dynamicProgramming.LeetCode_300;

import java.util.Arrays;

/**
 * The class is 最长公共字符列。
 *
 * @author YuCheng
 * @version 2020/1/1 14:40
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,5,3,7,1};
        int lengthOfLIS = solution.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int ind = Arrays.binarySearch(dp, 0, len, n);
            if (ind < 0) {
                ind = -(ind+1);
            }
            dp[ind] = n;
            if (ind == len) {
                len++;
            }
        }
        return len;
    }
}
