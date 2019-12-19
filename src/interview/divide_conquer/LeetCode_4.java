package interview.divide_conquer;

public class LeetCode_4 {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums = merge(nums1, nums2);
            int mid = (nums.length - 1) / 2;
            return ((nums.length - 1) % 2 == 0) ? nums[mid]: (nums[mid] + nums[mid + 1]) / 2.0;
            /**
             int mid = (nums.length - 1) / 2;
             if (nums.length ! 2 == 0) {
             return nums[mid];
             } else {
             return (nums[mid] + nums[mid + 1]) / 2 ;
             }
             */
        }

        public int[] merge(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int index1 = 0;
            int index2 = 0;

            int[] nums = new int[len1 + len2];
            int index = 0;
            while (index1 < len1 && index2 < len2) {
                if (nums1[index1] <= nums2[index2]) {
                    nums[index++] = nums1[index1++];
                } else if (nums1[index1] > nums2[index2]) {
                    nums[index++] = nums2[index2++];
                }
            }
            if (index1 == len1) {
                System.arraycopy(nums2, index2, nums, index, len1 + len2 - index);
            }
            if (index2 == len2) {
                System.arraycopy(nums1, index1, nums, index, len1 + len2 - index);
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1,3};
        int[] arr2 = {2,4};
        double medianSortedArrays = solution.findMedianSortedArrays(arr1, arr2);
        System.out.println(medianSortedArrays);
    }
}
