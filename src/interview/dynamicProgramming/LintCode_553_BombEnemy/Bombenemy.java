package interview.dynamicProgramming.LintCode_553_BombEnemy;

import java.util.Arrays;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/16 11:53
 */
public class Bombenemy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}};
        int maxKilledEnemies = solution.maxKilledEnemies(grid);
        System.out.println(maxKilledEnemies);
    }
}
class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    int[][] upmemo;
    int[][] downmemo;
    int[][] leftmemo;
    int[][] rightmemo;
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        upmemo = new int[m][n];
        downmemo = new int[m][n];
        leftmemo = new int[m][n];
        rightmemo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(upmemo[i], -1);
            Arrays.fill(downmemo[i], -1);
            Arrays.fill(leftmemo[i], -1);
            Arrays.fill(rightmemo[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(
                            up(grid, i - 1, j) +
                                    down(grid, i + 1, j) +
                                    left(grid, i, j - 1) +
                                    right(grid, i, j + 1), res);
                }
            }
        }
        return res;
    }
    // up
    private int up(char[][] c, int i, int j) {
        if (i >= 0) {
            if (upmemo[i][j] != -1) return upmemo[i][j];
            if (c[i][j] == 'W')
                return 0;

            upmemo[i - 1][j] = up(c, i - 1, j);
            return c[i][j] == 'E' ? upmemo[i - 1][j] + 1: upmemo[i - 1][j];
        } else {
            return 0;
        }
    }
    // down
    private int down(char[][] c, int i, int j) {
        if (i < c.length) {
            if (downmemo[i][j] != -1) return downmemo[i][j];
            if (c[i][j] == 'W')
                return 0;

            downmemo[i + 1][j] = down(c, i + 1, j);
            return c[i][j] == 'E' ? downmemo[i + 1][j] + 1: downmemo[i + 1][j];
        } else {
            return 0;
        }
    }
    // left
    private int left(char[][] c, int i, int j) {
        if (j >= 0) {
            if (leftmemo[i][j] != -1) return leftmemo[i][j];
            if (c[i][j] == 'W')
                return 0;

            leftmemo[i][j - 1] = left(c, i, j - 1);
            return c[i][j] == 'E' ? leftmemo[i][j - 1] + 1: leftmemo[i][j - 1];
        } else {
            return 0;
        }
    }
    // right
    private int right(char[][] c, int i, int j) {
        if (j < c[0].length) {
            if (rightmemo[i][j] != -1) return rightmemo[i][j];
            if (c[i][j] == 'W')
                return 0;

            rightmemo[i][j + 1] = right(c, i, j + 1);
            return c[i][j] == 'E' ? rightmemo[i][j + 1] + 1: rightmemo[i][j + 1];
        } else {
            return 0;
        }
    }
}
