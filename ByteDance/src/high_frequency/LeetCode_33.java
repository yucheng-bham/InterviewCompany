package high_frequency;

public class LeetCode_33 {
    static class Solution {
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] >= nums[start]) {
                    if (target >= nums[start] && target < nums[mid])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
                else {
                    if (target <= nums[end] && target > nums[mid])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
            return -1;
        }
        /*public int search(int[] nums, int target) {
            int endIndex = nums.length - 1;
            if (nums[endIndex] < nums[0])
                endIndex = binarySearchIndex(0, nums.length - 1, nums);
            if (target >= nums[0] && target <= nums[endIndex ]) {
                return binarySearch(0, endIndex , nums, target);
            } else {
                return binarySearch(endIndex + 1, nums.length - 1, nums, target);
            }
        }
        public int binarySearchIndex(int low, int high, int[] nums) {
            if (low == high) return low;
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[low]) {
                return binarySearchIndex(mid , high, nums);
            } else {
                return binarySearchIndex(low, mid, nums);
            }

        }
        public int binarySearch(int low, int high, int[] nums, int target) {
            if (low >= high) {
                return nums[high] == target ? high: -1;
            }
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                return binarySearch(low, mid, nums, target);
            } else {
                return binarySearch(mid + 1, high, nums, target);
            }
        }*/
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] input = {4,5,6,7,0,1,2};
//        int[] input = {7,8,9,0,1,2,3,4,5,6};
//        int[] input = {2,3,1};
//        int[] input = {3,1};
//        int[] input = {1,3};
        int[] input = {1,3};
        System.out.println(solution.search(input,0));
    }
}
