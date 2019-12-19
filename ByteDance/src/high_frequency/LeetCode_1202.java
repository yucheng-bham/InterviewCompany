package high_frequency;

import java.util.*;

public class LeetCode_1202 {
    static class Solution {
      /*
      版本一，速度非常慢。
      一是在并查集的创建时，没有优化结构，使用是树的结构p[i] = j，可是没有考虑将深度小的树并到深度高的树（平衡）;
      二是，使用了map这种数据结构作为图的邻接表，存储和表达交换关系，不如使用数组，直接映射有效率
      private class UnionFind {

         public int[] size;
         public int[] parent;

         UnionFind(int count) {
             size = new int[count];
             parent = new int[count];
             for (int i = 0; i < count; i++) {
                 size[i] = 1;
                 parent[i] = i;
             }
         }

         int find(int p) {
             while (p != parent[p]) {
                 parent[p] = parent[parent[p]];
                 p = parent[p];
             }
             return p;
         }

         int union(int p, int q) {
             int pRoot = find(p);
             int qRoot = find(q);
             if (pRoot == qRoot) {
                 return size[pRoot];
             }
             if (size[pRoot] > size[qRoot]) {
                 parent[qRoot] = pRoot;
                 size[pRoot] += size[qRoot];
                 return size[pRoot];
             } else {
                 parent[pRoot] = qRoot;
                 size[qRoot] += size[pRoot];
                 return size[qRoot];
             }

                 }
     }
        public String smallestStringWithSwaps(String s, List<List<Integer>> swaps) {
            int N = s.length();

            UnionFind uf = new UnionFind(N);
            for (List<Integer> swap : swaps) {
                uf.union(swap.get(0), swap.get(1));
            }


            Map<Integer, List<Character>> graphs = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int head = uf.find(i);
                List<Character> characters = graphs.computeIfAbsent(head, (dummy) -> new ArrayList<>());
                characters.add(s.charAt(i));
            }

            for (List<Character> characters : graphs.values()) {
                Collections.sort(characters);
            }

            StringBuilder sb = new StringBuilder(N);
            for (int i = 0; i < N; i++) {
                List<Character> characters = graphs.get(uf.find(i));
                char currentMin = characters.remove(0);
                sb.append(currentMin);
            }
            return sb.toString();


        }*/
        /*public String smallestStringWithSwaps(String s, List<List<Integer>> swaps) {
            int[] p = new int[s.length()];

            // Initlization of parents
            for (int i = 0; i < s.length(); ++i)
                p[i] = i;

            // Create subsets using edges
            for (int i = 0; i < swaps.size(); ++i) {
                List<Integer> pair = swaps.get(i);
                union(p, pair.get(0), pair.get(1));
            }

            // Key Function to order subsets
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < s.length(); ++j) {
                int parent = find(p, j);
                if (!map.containsKey(parent)) {
                    map.put(parent, new ArrayList<>());
                }
                map.get(parent).add(j);
            }

            char[] arr = s.toCharArray();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> nums = entry.getValue();
                List<Character> temp = new ArrayList<>();
                for (int i : nums) {
                    temp.add(arr[i]);
                }
                Collections.sort(temp);
                for (int k = 0; k < nums.size(); ++k)
                    arr[nums.get(k)] = temp.get(k);
            }
            return new String(arr);
        }

        public void union(int[] p, int i, int j) {
            int i_p = find(p, i);
            int j_p = find(p, j);
            if (i_p != j_p)
                p[i_p] = j_p;
        }

        public int find(int[] p, int j) {
            if (p[j] == j)
                return p[j];
            p[j] = find(p, p[j]);
            return p[j];
        }*/

        /**
         *
         * @param s
         * @param pairs
         * @return the Character in String s is in ascending order lexicographically
         *
         * @version third
         */
     /* public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
          // 借助并查集这种数据结构。来实现在String中，两两两个位置的字符可以交换，即List<List<Integer>> pairs
          //
          char[] carr = s.toCharArray();
          UnionFind uf = new UnionFind(carr.length);
          for(List<Integer> list : pairs){
              uf.union(list.get(0), list.get(1));
          }
          // 使用list[]来代替map作为图的邻接表，表示可以连通关系（即那些点是连通的），在这里可以看到，虽然开辟了4个空间，可是只用两个空间（以3为根的0,3 和 以2为根的1,2的两个连通分量）
          List<Integer>[] list = new List[carr.length];
          for(int i = 0; i < list.length; i++){
              list[i] = new ArrayList<>();
          }
          for(int i = 0; i < carr.length; i++){
              int p = uf.find(i);
              list[p].add(i);
          }

          for(int i = 0; i < carr.length; i++){
              if(list[i].size() > 0){
                  // 怎么使用连通分量来重构carr数组，也就是String。
                  // list[i]以i为根的连通分量，get[j]就是取到第j个顶点，carr[list[i].get[j]]就是一个元素j在连通分量i在数组中表示。将其放到temp[]数组中，主要是为里排序，Arrays.sort(temp).排序后，再将排序后的结果再放到list[i]的连通分量里。这时，temp[j]将结果放到原来数组中，当然是按照连通分量list[i].get[j]来放的。毕竟取这个临时数组就是怎么取到的，放回就怎么放。
                  char[] temp = new char[list[i].size()];
                  for(int j = 0; j < temp.length; j++){
                      temp[j] = carr[list[i].get(j)];
                  }
                  Arrays.sort(temp);
                  for(int j = 0; j < temp.length; j++){
                      carr[list[i].get(j)] = temp[j];
                  }
              }
          }
          return new String(carr);
      }
        class UnionFind{
            int[] parent;
            public UnionFind(int n){
                parent = new int[n];
                for(int i = 0; i < n; i++){
                    parent[i] = i;
                }
            }
            public void union(int p, int q){
                int m = find(p);
                int n = find(q);
                if(m != n){
                    parent[m] = n;
                }
            }
            public int find(int m){
                if(parent[m] != m){
                    parent[m] = find(parent[m]);
                }
                return parent[m];
            }
        }
    }


*/
            class UnionFind {
                int[] parent;
                public UnionFind(int n) {
                    parent = new int[n];
                    for (int i = 0; i < n; i++) {
                        parent[i] = i;
                    }
                }
                public void union(int p, int q) {
                    int m = find(p);
                    int n = find(q);
                    if(m != n){
                        parent[m] = n;
                    }
//                    int root_p = find(p);
//                    int root_q = find(q);
//                    if (root_p != root_q) {
//                        parent[p] = root_q;
//                    }
                }
                public int find(int i) {
                    if (parent[i] != i) {
                        parent[i] = find(parent[i]);
                    }
                    return parent[i];
                }

            }
            public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
                // 借助并查集这种数据结构。来实现在String中，两两两个位置的字符可以交换，即List<List<Integer>> pairs
                char[] carr = s.toCharArray();
                UnionFind uf = new UnionFind(carr.length);
                for (List<Integer> pair: pairs) {
                    uf.union(pair.get(0), pair.get(1));
                }
                // 使用list[]来代替map作为图的邻接表，表示可以连通关系（即那些点是连通的），在这里可以看到，虽然开辟了4个空间，可是只用两个空间（以3为根的0,3 和 以2为根的1,2的两个连通分量）
                List<Integer>[] map = new List[carr.length];
                for (int i = 0; i < map.length; i++) {
                    map[i] = new ArrayList<>();
                }
                for (int i = 0; i < carr.length; i++) {
                    int p = uf.find(i);
                    map[p].add(i);
                }

                // 怎么使用连通分量来重构carr数组，也就是String。
                // list[i]以i为根的连通分量，get[j]就是取到第j个顶点，carr[list[i].get[j]]就是一个元素j在连通分量i在数组中表示。将其放到temp[]数组中，主要是为里排序，Arrays.sort(temp).排序后，再将排序后的结果再放到list[i]的连通分量里。这时，temp[j]将结果放到原来数组中，当然是按照连通分量list[i].get[j]来放的。毕竟取这个临时数组就是怎么取到的，放回就怎么放。
                for (int i = 0; i < map.length; i++) {
                    if (map[i].size() > 0) {
                        char[] temp = new char[map[i].size()];
                        for (int j = 0; j < temp.length; j++) {
                            temp[j] = carr[map[i].get(j)];
                        }
                        Arrays.sort(temp);
                        for (int j = 0; j < temp.length; j++) {
                            carr[map[i].get(j)] = temp[j];
                        }
                    }
                }
                return new String(carr);
            }
        }

        public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = new ArrayList();
        List<Integer> list1 = Arrays.asList(0, 3);
        List<Integer> list2 = Arrays.asList(1, 2);
        List<Integer> list3 = Arrays.asList(0, 2);
        list.add(new ArrayList<>(list1));
        list.add(new ArrayList<>(list2));
        list.add(new ArrayList<>(list3));
        String smallestStringWithSwaps = solution.smallestStringWithSwaps("dcab", list);
        System.out.println(smallestStringWithSwaps);
    }
}
