package interview.dynamicProgramming.LintCode_515_PaintHouse;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/15 23:06
 */
public class Painthouse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
        int minCost = solution.minCost(costs);
        System.out.println(minCost);
    }
}
class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;
        int[][] f = new int[m][n];
        f[0][0] = costs[0][0];
        f[0][1] = costs[0][1];
        f[0][2] = costs[0][2];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*f[i][0] = Math.min(f[i - 1][1] + costs[i][0], f[i - 1][2] + costs[i][0]);
                f[i][1] = Math.min(f[i - 1][0] + costs[i][1], f[i - 1][2] + costs[i][1]);
                f[i][2] = Math.min(costs[i][2] + f[i - 1][0], costs[i][2] + f[i - 1][1]);*/
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        f[i][j] = Math.min(costs[i][j] + f[i - 1][k], f[i][j]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[m - 1][i]);
        }
        return res;
    }
}