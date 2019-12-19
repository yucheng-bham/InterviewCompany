package interview.divide_conquer;

import java.util.Arrays;
import java.util.Random;

public class LeetCode_215 {
    // import java.util.Random;
    static class Solution {
//   int [] nums;

//   public void swap(int a, int b) {
//     int tmp = this.nums[a];
//     this.nums[a] = this.nums[b];
//     this.nums[b] = tmp;
//   }


//   public int partition(int left, int right, int pivot_index) {
//     int pivot = this.nums[pivot_index];
//     // 1. move pivot to end
//     swap(pivot_index, right);
//     int store_index = left;

//     // 2. move all smaller elements to the left
//     for (int i = left; i < right; i++) {
//       if (this.nums[i] < pivot) {
//         swap(store_index, i);
//         store_index++;
//       }
//     }

//     // 3. move pivot to its final place
//     swap(store_index, right);

//     return store_index;
//   }

//   public int quickselect(int left, int right, int k_smallest) {
//     /*
//     Returns the k-th smallest element of list within left..right.
//     */

//     if (left == right) // If the list contains only one element,
//       return this.nums[left];  // return that element

//     // select a random pivot_index
//     Random random_num = new Random();
//     int pivot_index = left + random_num.nextInt(right - left);

//     pivot_index = partition(left, right, pivot_index);

//     // the pivot is on (N - k)th smallest position
//     if (k_smallest == pivot_index)
//       return this.nums[k_smallest];
//     // go left side
//     else if (k_smallest < pivot_index)
//       return quickselect(left, pivot_index - 1, k_smallest);
//     // go right side
//     return quickselect(pivot_index + 1, right, k_smallest);
//   }

        public int findKthLargest(int[] nums, int k) {
            return quickselect(nums, 0, nums.length - 1, nums.length - k);
        }
        public int quickselect(int[] nums, int left, int right, int target) {
            if (left == right) return nums[left];

            Random random = new Random();
            int pivot_index = left + random.nextInt(right - left);

            pivot_index = partition(nums, left, right, pivot_index);
            if (pivot_index == target) {
                return nums[target];
            }
            if (pivot_index < target) {
                return quickselect(nums, pivot_index + 1, right, target);
            } else
                return quickselect(nums, left, pivot_index - 1, target);

        }
        public int partition(int[] nums, int l, int r, int pivot) {
            int val = nums[pivot];
            swap(nums, pivot, r);
            int pi = l;
            int i = 0;
            while (i < r - 1) {
                if (nums[i] < val) {
                    swap(nums, i, pi);
                    pi++;
                }
                i++;
            }
            swap(nums, pi, r);
            return pi;
        }
        public void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int kthLargest = solution.findKthLargest(arr, 4);
        System.out.println(kthLargest);
    }
}
