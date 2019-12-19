package high_frequency;

import java.util.Arrays;

public class LeetCode_41 {
    static class Solution {
        /*public int firstMissingPositive(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
//            Arrays.sort(nums);
            for (int num: nums) {
                if (num > 0) {
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                }
            }
            if (min > 1) return 1;
            boolean[] arr = new boolean[max + 1];
            for (int num : nums) {
                if (num > 0) {
                    arr[num] = true;
                }
            }
            int index = 1;
            while (index <= max && arr[index]) {
                index++;
            }
            return index;
        }*/
         public int firstMissingPositive(int[] nums) {
             int i = 0;
             while (i < nums.length) {
                 if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
                 else if (nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
                 else i++;
             }
             i = 0;
             while (i < nums.length && nums[i] == i + 1) i++;
             return i + 1;
         }
         public void swap(int[] nums, int i, int j) {
             int temp = nums[i];
             nums[i] = nums[j];
             nums[j] = temp;
         }
        /*public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Base case.
            int contains = 0;
            for (int i = 0; i < n; i++)
                if (nums[i] == 1) {
                    contains++;
                    break;
                }

            if (contains == 0)
                return 1;

            // nums = [1]
            if (n == 1)
                return 2;

            // Replace negative numbers, zeros,
            // and numbers larger than n by 1s.
            // After this convertion nums will contain
            // only positive numbers.
            for (int i = 0; i < n; i++)
                if ((nums[i] <= 0) || (nums[i] > n))
                    nums[i] = 1;

            // Use index as a hash key and number sign as a presence detector.
            // For example, if nums[1] is negative that means that number `1`
            // is present in the array.
            // If nums[2] is positive - number 2 is missing.
            for (int i = 0; i < n; i++) {
                int a = Math.abs(nums[i]);
                // If you meet number a in the array - change the sign of a-th element.
                // Be careful with duplicates : do it only once.
                if (a == n)
                    nums[0] = - Math.abs(nums[0]);
                else
                    nums[a] = - Math.abs(nums[a]);
            }

            // Now the index of the first positive number
            // is equal to first missing positive.
            for (int i = 1; i < n; i++) {
                if (nums[i] > 0)
                    return i;
            }

            if (nums[0] > 0)
                return n;

            return n + 1;
        }*/

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {7,4,2,3,6, -1, 7};
//        int[] arr = {4,3,1,5,2};
//        int[] arr = {3,2,2};
        int[] arr = {1,2,0};

//        int[] arr = {7,8,9,11,12};
        System.out.println(solution.firstMissingPositive(arr));
    }
}
