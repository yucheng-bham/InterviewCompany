package interview.dynamicProgramming.LeetCode_188;

/**
 * The class is 买卖股票，不过这次是以K为交易次数。最难。融合了前面的三个类型。
 *
 * @author YuCheng
 * @version 2020/1/4 11:00
 */
public class BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {3,2,6,5,0,3};
        int[] prices = {0,3,2,6,1,3};
        int maxProfit = solution.maxProfit(2, prices);
        System.out.println(maxProfit);
    }
}
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <=1){
            return 0;
        }
        // BEST time to sell stockII
        if(k>=prices.length/2){
            int profit = 0;
            for(int j=1;j<prices.length;j++){
                if(prices[j] > prices[j-1]){
                    profit += prices[j]-prices[j-1];
                }
            }
            return profit;
        }

        int[] dp = new int[prices.length];


        for(int i =1;i<k+1;i++){
            int[] cur = new int[dp.length];
            // cur[0] will by default be 0; so not necessary
            //cur[0]= 0;
            // temp is used to minimize the code.
            int temp = dp[0] - prices[0];
            for(int j = 1;j<prices.length;j++){
                // int max = 0;
                // for(int m=0;m<j;m++){
                //     max = Math.max(max, prices[j]+dp[i-1][m]-prices[m]);
                // }
                // dp[i][j] = Math.max(max,dp[i][j-1]);
                cur[j] = Math.max(cur[j-1], temp + prices[j]);
                temp = Math.max(temp, dp[j]-prices[j]);
            }
            dp = cur;
        }

        return dp[prices.length-1];
    }
}
