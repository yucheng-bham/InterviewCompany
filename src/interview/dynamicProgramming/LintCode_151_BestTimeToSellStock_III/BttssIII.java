package interview.dynamicProgramming.LintCode_151_BestTimeToSellStock_III;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/18 17:26
 */
public class BttssIII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {4,4,6,1,1,4,4,2,5};
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) return 0;
        int m = prices.length;
        int[][] f = new int[m + 1][5 + 1];
        for (int j = 1; j <= 5; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
        f[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            // 1, 3, 5 : f[i - 1][j]
            for (int j = 1; j <= 5; j+= 2) {
                // not buy new stock yet
                f[i][j] = f[i - 1][j];
                if (j > 1 && i > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    // sell today.
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // 2, 4
            for (int j = 2; j <= 5; j += 2) {
                // buy the stock today? why not -prices[i]. This is because the
                f[i][j] = f[i - 1][j - 1];
                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
                    // keep state, calculate the profit today. similiar to II
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        return Math.max(Math.max(f[m][1], f[m][3]), f[m][5]);
    }
}
