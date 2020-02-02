package interview.dynamicProgramming.LintCode_563;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/7 22:16
 */
public class BackpackV {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        int backPackV = solution.backPackV(arr, 3);
        System.out.println(backPackV);
    }
}
class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // no using item
                f[i][j] = f[i - 1][j];
                // using last item
                if (j >= nums[i - 1]) {
                    f[i][j] = f[i][j] + f[i - 1][j - nums[i - 1]];
                }
            }
        }
        return f[n][target];
    }
}