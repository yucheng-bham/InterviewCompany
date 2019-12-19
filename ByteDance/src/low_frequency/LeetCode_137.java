package low_frequency;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LeetCode_137 {
    static class Solution {
        /**
         The idea is to
         change seen_once only if seen_twice is unchanged
         change seen_twice only if seen_once is unchanged

         */
        public int singleNumber(int[] nums) {
            int seenOnce = 0;
            int seenTwice = 0;
            for (int num: nums) {
                seenOnce = ~seenTwice & (seenOnce ^ num);
                seenTwice = ~seenOnce & (seenTwice ^ num);
            }
            return seenOnce;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,2,2,2,2};
        int i = solution.singleNumber(arr);
        System.out.println(i);
    }
}
