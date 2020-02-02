package LintCode1406_MSSS;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/30 20:44
 */
public class l406_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {9, 1, 8, 2, 7, 3, 6, 4, 5, 10};
        int[] arr = {2, 3, 1, 2, 4, 3};
        int minimumSize = solution.minimumSize(arr, 7);
        System.out.println(minimumSize);
    }
}

class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int anslen = Integer.MAX_VALUE;
        int[] sum = new int[nums.length + 1];
//        sum[0] = nums[0];
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // sum
                if (sum[i] - sum[j] >= s) {
                    anslen = Math.min(anslen, i - j);
                }

            }
        }
        return anslen == Integer.MAX_VALUE ? -1: anslen;
    }
}