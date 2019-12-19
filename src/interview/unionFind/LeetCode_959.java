package interview.unionFind;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class LeetCode_959 {
    static class Solution {
        /* public int regionsBySlashes(String[] grid) {
             int N = grid.length;
             DSU dsu = new DSU(4 * N * N);
             for (int r = 0; r < N; ++r)
                 for (int c = 0; c < N; ++c) {
                     int root = 4 * (r * N + c);
                     char val = grid[r].charAt(c);
                     if (val != '\\') {
                         dsu.union(root + 0, root + 1);
                         dsu.union(root + 2, root + 3);
                     }
                     if (val != '/') {
                         dsu.union(root + 0, root + 2);
                         dsu.union(root + 1, root + 3);
                     }

                     // north south
                     if (r + 1 < N)
                         dsu.union(root + 3, (root + 4 * N) + 0);
                     if (r - 1 >= 0)
                         dsu.union(root + 0, (root - 4 * N) + 3);
                     // east west
                     if (c + 1 < N)
                         dsu.union(root + 2, (root + 4) + 1);
                     if (c - 1 >= 0)
                         dsu.union(root + 1, (root - 4) + 2);
                 }

             int ans = 0;
             for (int x = 0; x < 4 * N * N; ++x) {
                 if (dsu.find(x) == x)
                     ans++;
             }

             return ans;
         }
     }

     static class DSU {
         int[] parent;
         public DSU(int N) {
             parent = new int[N];
             for (int i = 0; i < N; ++i)
                 parent[i] = i;
         }
         public int find(int x) {
             if (parent[x] != x) parent[x] = find(parent[x]);
             return parent[x];
         }
         public void union(int x, int y) {
             parent[find(x)] = find(y);
         }*/
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            DSU dsu = new DSU(n * n * 4);
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int root = (r  * n + c) * 4;
                    char val = grid[r].charAt(c);
                    if (val != '\\') {
                        dsu.union(root, root + 1);
                        dsu.union(root + 2, root + 3);
                    }
                    if (val != '/') {
                        dsu.union(root, root + 2);
                        dsu.union(root + 1, root + 3);
                    }

                    // connected adjacent grid
                    // north -> south
                    if (r + 1 < n) {
                        dsu.union(root + 3, root + n * 4);
                    }
                    // east -> west
                    if (c + 1 < n) {
                        dsu.union(root + 2, root + 4 + 1);
                    }
                    // south -> north
                    if (r - 1 >= 0) {
                        dsu.union(root, root - 4 * n + 3);
                    }
                    // west -> east
                    if (c - 1 >= 0) {
                        dsu.union(root + 1, root - 4 + 2);
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n * n; i++) {
                if (i == dsu.find(i)) {
                    ans++;
                }
            }
            return ans;
        }
        class DSU{
            int[] parent;
            public DSU(int num) {
                parent = new int[num];
                for (int i = 0; i < num; i++) {
                    parent[i] = i;
                }
            }
            public int find(int i) {
                if (parent[i] != i) {
                    parent[i] = find(parent[i]);
                }
                return parent[i];
            }
            public void union(int p, int q) {
                int pr = find(p);
                int qr = find(q);
                if (pr != qr) {
                    parent[pr] = qr;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] arr = {"/\\", "\\/"};
        String[] arr = {"//", "/ "};
        int regionsBySlashes = solution.regionsBySlashes(arr);
        System.out.println(regionsBySlashes);
    }
}
