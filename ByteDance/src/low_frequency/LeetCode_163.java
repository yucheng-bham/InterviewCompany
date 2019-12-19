package low_frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_163 {
    static class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                if (lower < upper) {
                    res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
                } else if (lower == upper) {
                    res.add(String.valueOf(lower));
                }
                return res;

            }
            long lrange = lower;
            long rrange = upper;
            if (nums[0] > lower) {
                rrange = nums[0] - 1;
                if (lrange < rrange)
                    res.add(String.valueOf(lrange) + "->" + String.valueOf(rrange));
                else
                    res.add(String.valueOf(lrange));
                lrange = nums[0];
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < lower) continue;
                if (nums[i] > upper) break;
                if (nums[i] == lrange) lrange++;
                else if (nums[i] > lrange) {
                    rrange = nums[i] - 1;
                    if (lrange < rrange)
                        res.add(String.valueOf(lrange) + "->" + String.valueOf(rrange));
                    else
                        res.add(String.valueOf(lrange));
                    lrange = nums[i] + 1;
                }
            }
            if (lrange <= upper) {
                rrange = upper;
                if (lrange != rrange)
                    res.add(String.valueOf(lrange) + "->" + String.valueOf(rrange));
                else
                    res.add(String.valueOf(lrange));

            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {0,1,3,50, 75};
        int[] arr = {Integer.MIN_VALUE,Integer.MAX_VALUE};
        System.out.println(solution.findMissingRanges(arr,  Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
