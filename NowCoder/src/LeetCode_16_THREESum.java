import java.util.Arrays;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/6/23 23:46
 */
public class LeetCode_16_THREESum {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length == 0) return 0;
            Arrays.sort(nums);
            int m = nums.length;
            int[] dp = new int[m - 2];
            for (int i = 0; i < 3; i++) dp[0] += nums[i];
            if (target < dp[0]) {
                return dp[0];
            }
            for (int i = 3; i < m; i++) {
                dp[i - 2] = dp[i - 3] + nums[i] - nums[i - 3];

                // dp[i - 2] -= nums[i - 2];
            }
            if (dp[m - 3] < target) return dp[m - 3];
            // binarySearch
            int index = Arrays.binarySearch(dp, 0, m - 3, target);
            if (index < 0) {
                index = -index - 1;
            }

            return dp[index];
        }

    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        LeetCode_16_THREESum sum = new LeetCode_16_THREESum();
        int res = sum.threeSumClosest(nums, -1);
        System.out.println(res);
    }
}
