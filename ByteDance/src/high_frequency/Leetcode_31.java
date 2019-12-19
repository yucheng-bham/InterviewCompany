package high_frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_31 {
    static class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1,5,8,4,7,6,5,3,1};
        int[] nums = {3,2,1};
//        int[] nums = {1,5,3,2};
//        int[] nums = {1,3,2,0};
//        int[] nums = {1,3,2,5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
