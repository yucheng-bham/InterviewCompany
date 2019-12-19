package interview.unionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_128 {
    static class Solution {
        // 快排的实现
     /*   public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int longestStreak = 1;
            int currentStreak = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i-1]) {
                    if (nums[i] == nums[i-1]+1) {
                        currentStreak += 1;
                    }
                    else {
                        longestStreak = Math.max(longestStreak, currentStreak);
                        currentStreak = 1;
                    }
                }
            }

            return Math.max(longestStreak, currentStreak);
        }*/
        //通过集合实现
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {0,1,1,2};
        int[] arr = {100, 4, 200, 1, 3, 2};
        int longestConsecutive = solution.longestConsecutive(arr);
        System.out.println(longestConsecutive);
    }
}
