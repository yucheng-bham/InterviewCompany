package LeetCode_407_TrappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-2-2
 */
class SolutionTest{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        int trapRainWater = solution.trapRainWater(nums);
        System.out.println(trapRainWater);
    }
}
class Solution {
    class Cell {
        int row;
        int col;
        int height;
        public Cell (int x, int y, int h) {
            this.row = x;
            this.col = y;
            this.height = h;
        }
    }
    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return 0;
        PriorityQueue<Cell> minheap = new PriorityQueue<Cell>(1, new Comparator<Cell>(){
            @Override
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            minheap.add(new Cell(i, 0, heights[i][0]));
            minheap.add(new Cell(i, n - 1, heights[i][n - 1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            minheap.add(new Cell(0, i, heights[0][i]));
            minheap.add(new Cell(m - 1, i, heights[m - 1][i]));
        }
        int res = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};
        while (!minheap.isEmpty()) {
            Cell cur = minheap.poll();
            for (int[] dir: dirs) {
                int nx = cur.row + dir[0];
                int ny = cur.col + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    res += Math.max(0, cur.height - heights[nx][ny]);
                    minheap.add(new Cell(nx, ny, Math.max(heights[nx][ny], cur.height)));
                }
            }
        }
        return res;
    }
}
