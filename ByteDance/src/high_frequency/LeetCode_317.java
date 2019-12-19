package high_frequency;

import java.util.*;

public class LeetCode_317 {
    /*static class Solution {
        public int shortestDistance(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            // int[][] houses = new int[row * col][2];
            List<int[]> houses = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        // houses.add(new ArrayList<>());
                        houses.add( new int[]{ i, j});
                    }
                }
            }
            List<int[][]> list = new ArrayList<>();
            for (int[] house: houses) {
                int[][] housegraph = new int[row][col];
                for (int[] temp: housegraph) Arrays.fill(temp, Integer.MAX_VALUE);
                bfs(house[0], house[1], grid, new boolean[row][col], 0, housegraph);
                list.add(housegraph);
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 0) {
                        long ijpath = 0;
                        for (int[][] housegraph: list){
                            ijpath += housegraph[i][j];
                        }
                        res = (ijpath >= res) ? res: Math.min(res, (int)ijpath);
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1: res;
        }
        public void bfs(int i, int j, int[][] grid, boolean[][] visited, int level, int[][] housegraph) {
            if (i < 0 || i == grid.length || j < 0 || j== grid[0].length || visited[i][j] || (level != 0 && grid[i][j] != 0)) {
                return;
            }
            housegraph[i][j] = Math.min(housegraph[i][j],level);
            visited[i][j] = true;
            bfs(i - 1, j, grid, visited, level + 1, housegraph);
            bfs(i , j + 1, grid, visited, level + 1, housegraph);
            bfs(i + 1, j , grid, visited, level + 1, housegraph);
            bfs(i, j - 1, grid, visited, level + 1, housegraph);
            visited[i][j] = false;
        }
    }*/
static class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length, buildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                }
            }
        }
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && walk(grid, i, j, dist, reach) < buildings) {
                    return -1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

    private int walk(int[][] grid, int i, int j, int[][] dist, int[][] reach) {
        Queue<Integer> rq = new ArrayDeque<>();
        Queue<Integer> cq = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        rq.offer(i);
        cq.offer(j);
        int steps = 1, buildings = 1;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!rq.isEmpty()) {
            int size = rq.size();
            while (size-- > 0) {
                int r = rq.poll(), c = cq.poll();
                for (int[] dir : dirs) {
                    int x = r + dir[0], y = c + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        if (grid[x][y] == 0) {
                            reach[x][y]++;
                            dist[x][y] += steps;
                            visited[x][y] = true;
                            rq.offer(x);
                            cq.offer(y);
                        }
                        else if (grid[x][y] == 1) {
                            visited[x][y] = true;
                            buildings++;
                        }
                    }
                }
            }
            steps++;
        }
        return buildings;
    }
}

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {
                /*{1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}*/

                {1,1,0}

               /* {1,1,1,1,1,0},
                {0,0,0,0,0,1},
                {0,1,1,0,0,1},
                {1,0,0,1,0,1},
                {1,0,1,0,0,1},
                {1,0,0,0,0,1},
                {0,1,1,1,1,0}*/

               /* {2,0,0,2,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,1,2,0,2,0,1,1,0},
                {0,1,0,1,1,2,0,0,2,0,0,2,0,2,2,0,2,0,2,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,2,0,0,2,0,2,0,0,0,0,0,0,0,0,0,2,0,2,0,0,0,0,0,2},
                {0,0,2,2,2,1,0,0,2,0,0,0,0,0,0,0,0,0,2,2,2,2,1,0,0,0,0,0},
                {0,2,0,2,2,2,2,1,0,0,0,0,1,0,2,0,0,0,0,2,2,0,0,0,0,2,2,1},
                {0,0,2,1,2,0,2,0,0,0,2,2,0,2,0,2,2,2,2,2,0,0,0,0,2,0,2,0},
                {0,0,0,2,1,2,0,0,2,2,2,1,0,0,0,2,0,2,0,0,0,0,2,2,0,0,1,1},
                {0,0,0,2,2,0,0,2,2,0,0,0,2,0,2,2,0,0,0,2,2,0,0,0,0,2,0,0},
                {2,0,2,0,0,0,2,0,2,2,0,2,0,0,2,0,0,2,1,0,0,0,2,2,0,0,0,0},
                {0,0,0,0,0,2,0,2,2,2,0,0,0,0,0,0,2,1,0,2,0,0,2,2,0,0,2,2}*/

    };
        System.out.println(sol.shortestDistance(input));
    }
}
