package high_frequency;

import java.util.*;

public class LeetCode_286 {
    static class Solution {
        public void wallsAndGates(int[][] rooms) {
            int row = rooms.length;
            if (row == 0 ) return;
            int col = rooms[0].length;
            // List<int[]> gates = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (rooms[i][j] == 0) {
                        // bfs(rooms, i, j);
                        dfs(rooms, i, j, 0);
                    }
                }
            }
        }
        private void dfs(int[][] rooms, int i, int j, int distance)
        {
            if (i < 0 || i >= rooms.length || j < 0 ||  j >= rooms[0].length || rooms[i][j] < distance)
            {
                return ;
            }
            //rooms[i][j] < distance as infinity is Integer max value, if something is negative return else, update max value.
            rooms[i][j] = distance;
            dfs(rooms, i - 1, j, distance + 1);
            dfs(rooms, i, j + 1, distance + 1);
            dfs(rooms, i + 1, j, distance + 1);
            dfs(rooms, i, j - 1, distance + 1);

        }
        /*private static final int EMPTY = Integer.MAX_VALUE;
        private static final int GATE = 0;
        private static final List<int[]> DIRECTIONS = Arrays.asList(
                new int[]{-1, 0},
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1}
        );

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            if (m == 0) return;
            int n = rooms[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (rooms[row][col] == GATE) {
                        q.add(new int[]{row, col});
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];
                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                        continue;
                    }
                    rooms[r][c] = rooms[row][col] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }*/
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {
                {Integer.MAX_VALUE, -1, 0,  Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,  -1},
                {Integer.MAX_VALUE,  -1, Integer.MAX_VALUE,  -1},
                {0,  -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        solution.wallsAndGates(input);
        int row = input.length;
        int col = input[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(  input[i][j]);
            }
            System.out.println();
        }
    }
}
