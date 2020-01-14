package interview.dynamicProgramming.LeetCode_309;

/**
 * The class is 无限买卖的交易，不过是有cooldown一天的。
 *
 * @author YuCheng
 * @version 2020/1/4 12:28
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {1,2,3,0,2};
        int[] prices = {1,2,3,1,3};
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int presell = 0, sell = 0;
        int prebuy = Integer.MIN_VALUE, buy = Integer.MIN_VALUE;
        for (int p: prices) {
            prebuy = buy;
            buy = Math.max(presell - p, prebuy);
            presell = sell;
            sell = Math.max(buy + p, presell);
        }
        return sell;
    }
}
