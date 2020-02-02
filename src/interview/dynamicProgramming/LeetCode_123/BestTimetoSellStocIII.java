package interview.dynamicProgramming.LeetCode_123;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/3 23:53
 */
public class BestTimetoSellStocIII {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {3,4,0,3,1,4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        // Assume we only have 0 money at first
        for(int i:prices){
            // The maximum if we've just sold 2nd stock so far.
            release2 = Math.max(release2, hold2 + i);
            // The maximum if we've just buy  2nd stock so far.
            hold2 = Math.max(hold2, release1 - i);
            // The maximum if we've just sold 1nd stock so far.
            release1 = Math.max(release1, hold1 + i);
            // The maximum if we've just buy  1st stock so far.
            hold1 = Math.max(hold1, -i);
        }
        //Since release1 is initiated as 0, so release2 will always higher than release1.
        return release2;
    }
}
