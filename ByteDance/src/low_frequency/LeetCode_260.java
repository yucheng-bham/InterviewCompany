package low_frequency;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode_260 {
    static class Solution {
        public int[] singleNumber(int[] nums) {
            // difference between two numbers (x and y) which were seen only once
            int bitmask = 0;
            for (int num : nums) bitmask ^= num;

            // rightmost 1-bit diff between x and y
            int diff = bitmask & (-bitmask);

            int x = 0;
            // bitmask which will contain only x
            for (int num : nums)
                if ((num & diff) != 0)
                    x ^= num;

            return new int[]{x, bitmask^x};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,1,4, 2, 5};
        int[] ints = solution.singleNumber(arr);
        System.out.println(Arrays.toString(ints));
    }
}
