package interview.dynamicProgramming.LeetCode_64;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/1 10:47
 */
public class MinPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}};
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        int old = 0;
        int now = 0;
        for (int i = 0; i < m; i++) {
            old = now;
            now = 1 - old;
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[now][j] = grid[i][j];
                    continue;
                }
                dp[now][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[now][j] = Math.min(dp[now][j], dp[old][j] + grid[i][j]);
                }
                if (j > 0) {
                    dp[now][j] = Math.min(dp[now][j], dp[now][j - 1] + grid[i][j]);
                }
            }
        }
        return dp[now][n - 1];
    }
}
/*class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] sum = new int[n];
        sum[0] = grid[0][0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + grid[0][i];
        }
        for (int i = 1; i< m; i++){
            sum[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                if (sum[j]>sum[j-1])
                    sum[j] = sum[j-1];
                sum[j] += grid[i][j];
            }
        }
        return sum[n-1];
    }
}*/
