package LeetCode_259_3SumSmaller;

import java.util.Arrays;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/6/25 23:03
 */
public class Solution {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                 sum += right - left;
//                sum++;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumSmaller(new int[]{-2, 0, 1, 1, 3}, 2));
    }

}
