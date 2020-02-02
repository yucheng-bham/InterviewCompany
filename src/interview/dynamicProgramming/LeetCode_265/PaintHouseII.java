package interview.dynamicProgramming.LeetCode_265;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/2 23:19
 */
public class PaintHouseII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] costs = {
                {1,5,3},
                {2,9,4}
        };
        int minCostII = solution.minCostII(costs);
        System.out.println(minCostII);
    }
}
/*class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        // min1 is the index of the 1st-smallest cost till previous house
        // min2 is the index of the 2nd-smallest cost till previous house
        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;

            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    // current color j is different to last min1
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                // find the indices of 1st and 2nd smallest cost of painting current house i
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1; min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }

        return costs[n - 1][min1];
    }
}*/
class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int lastMinIndex = -1, min1 = 0, min2 = 0;
        for(int i = 0; i < n; i++){
            int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE, curMin = -1;
            for(int j = 0; j < k; j++){
                int cost = costs[i][j] + (j != lastMinIndex ? min1 : min2);
                if(cost < curMin1){
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curMin = j;
                }
                else if(cost < curMin2){
                    curMin2 = cost;
                }
            }
            min1 = curMin1;
            min2 = curMin2;
            lastMinIndex = curMin;
        }

        return min1;
    }
}
