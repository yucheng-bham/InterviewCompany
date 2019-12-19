package low_frequency;

import java.util.*;

public class LeetCode_399 {
    static class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            /* Build graph. */
            Map<String, Map<String, Double>> graph = buildgraph(equations, values);
            double[] ans = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                ans[i] = rec(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
            }
            return ans;
        }
        private double rec(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
            if (!graph.containsKey(start)) {
                return -1.0d;
            }
            if (graph.get(start).containsKey(end)) {
                return graph.get(start).get(end);
            }
            visited.add(start);
            for (Map.Entry<String, Double> entry: graph.get(start).entrySet()) {
                if (!visited.contains(entry.getKey())) {
                    double pathWeight= rec(entry.getKey(), end, visited, graph);
                    if (pathWeight != -1.0d) {
                        return entry.getValue() * pathWeight;
                    }
                }

            }
            return -1.0d;
        }




        private Map<String, Map<String, Double>> buildgraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> map = new HashMap<>();
            String u;
            String v;
            for (int i = 0; i < values.length; i++) {
                u = equations.get(i).get(0);
                v = equations.get(i).get(1);
                map.putIfAbsent(u, new HashMap<String, Double>());
                map.get(u).put(v, values[i]);
                map.putIfAbsent(v, new HashMap<String, Double>());
                map.get(v).put(u, 1 / values[i]);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = new ArrayList<>();
        String[][] strEqua = {{"a", "b"},{ "b", "c"}};
        for (int i = 0;i < strEqua.length; i++) {
            equations.add(new ArrayList<>(Arrays.asList(strEqua[i])));
        }
        /*for (int i = 0; i < equations.size(); i++) {
            System.out.println(equations.get(i));
        }*/

        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        String[][] strQue = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        for (int i = 0; i < strQue.length; i++) {
            queries.add(new ArrayList<>(Arrays.asList(strQue[i])));
        }
        /*for (int i = 0; i < queries.size(); i++) {
            System.out.println(queries.get(i));
        }*/
        double[] calcEquation = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(calcEquation));
    }
}
