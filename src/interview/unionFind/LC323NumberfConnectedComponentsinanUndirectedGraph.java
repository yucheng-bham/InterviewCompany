package interview.unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/2 22:39
 */
public class LC323NumberfConnectedComponentsinanUndirectedGraph {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,1},{0,2},{2,3},{2,4}};
        int countComponents = solution.countComponents(5, arr);
        System.out.println(countComponents);
    }
}
class Solution {
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                parent[root_a] = root_b;
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (res.isEmpty() || !res.contains(uf.find(i))) {
                res.add(uf.find(i));
            }
        }
        return res.size();
    }
}
