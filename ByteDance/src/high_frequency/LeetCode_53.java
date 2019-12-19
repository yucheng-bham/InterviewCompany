package high_frequency;

public class LeetCode_53 {
    static class Solution {
        /** 分治算法*/
        public int maxSubArray(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
        public int helper(int[] nums, int left, int right) {
            if (left == right) return nums[left];

            int mid = left + (right - left) / 2;
            int leftmax = helper(nums, left, mid);
            int rightmax = helper(nums, mid + 1, right);
            int curval = merge(nums, left, right, mid);

            return Math.max(curval, Math.max(leftmax, rightmax));
        }
        public int merge(int[] nums, int left, int right, int pivot) {
            // left
            int lmax = Integer.MIN_VALUE;
            int curval = 0;
            for (int i = pivot ; i >= left; i--) {
                curval += nums[i];
                lmax = Math.max(lmax, curval);
            }
            // right
            int rmax = Integer.MIN_VALUE;
            curval = 0;
            for (int i = pivot + 1; i <= right; i++) {
                curval += nums[i];
                rmax = Math.max(rmax, curval);
            }

            return lmax + rmax ;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {-2,1,-3,4};
        int maxSubArray = solution.maxSubArray(arr);
        System.out.println(maxSubArray);
    }
}
