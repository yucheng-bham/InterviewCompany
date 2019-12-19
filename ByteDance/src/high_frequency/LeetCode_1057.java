package high_frequency;

import java.util.*;

public class LeetCode_1057 {
    static class Solution {
        /**
         这个题使用了heap的思想，在java中是通过优先队列实现PriorityQueue。
         As the question states, there are n workers and m bikes, and m > n.
         We are able to solve this question using a greedy approach.

         1.initiate a priority queue of bike and worker pairs. The heap order should be Distance ASC, WorkerIndex ASC, Bike ASC
         2.Loop through all workers and bikes, calculate their distance, and then throw it to the queue.
         3.Initiate a set to keep track of the bikes that have been assigned.
         4.initiate a result array and fill it with -1. (unassigned)
         5.poll every possible pair from the priority queue and check if the person already got his bike or the bike has been assigned.
         6.early exist on every people got their bike.

         */

        /*public int[] assignBikes(int[][] workers, int[][] bikes) {
            int n = workers.length;

            // order by Distance ASC, WorkerIndex ASC, BikeIndex ASC
            PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
                int comp = Integer.compare(a[0], b[0]);
                if (comp == 0) {
                    if (a[1] == b[1]) {
                        return Integer.compare(a[2], b[2]);
                    }

                    return Integer.compare(a[1], b[1]);
                }

                return comp;
            });

            // loop through every possible pairs of bikes and people,
            // calculate their distance, and then throw it to the pq.
            for (int i = 0; i < workers.length; i++) {

                int[] worker = workers[i];
                for (int j = 0; j < bikes.length; j++) {
                    int[] bike = bikes[j];
                    int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                    q.add(new int[]{dist, i, j});
                }
            }

            // init the result array with state of 'unvisited'.
            int[] res = new int[n];
            Arrays.fill(res, -1);

            // assign the bikes.
            Set<Integer> bikeAssigned = new HashSet<>();
            while (bikeAssigned.size() < n) {
                int[] workerAndBikePair = q.poll();
                if (res[workerAndBikePair[1]] == -1
                        && !bikeAssigned.contains(workerAndBikePair[2])) {

                    res[workerAndBikePair[1]] = workerAndBikePair[2];
                    bikeAssigned.add(workerAndBikePair[2]);
                }
            }

            return res;
        }*/
        /*public int[] assignBikes(int[][] workers, int[][] bikes) {
            // step1 PriorityQueue
            Comparator<int[]> cmp = new Comparator<int[]>(){
                @Override
                public int compare (int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        if (a[1] == b[1]) {
                            return a[2] - b[2];
                        }
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
            };
            PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

            for (int i = 0; i < workers.length; i++) {
                for (int j = 0; j < bikes.length; j++) {
                    int dis = Math.abs(workers[i][0] - bikes[j][0]) +
                            Math.abs(workers[i][1] - bikes[j][1]);
                    pq.offer(new int[]{dis, i, j});
                }
            }

            int[] res = new int[bikes.length];
            Arrays.fill(res, -1);
            int[] worker = new int[workers.length];
            int[] bike = new int[bikes.length];
            Arrays.fill(worker,-1);
            Arrays.fill(bike,-1);
            int assigned = 0;
            while (assigned < bikes.length) {
                int[] temparr = pq.poll();
                if (worker[temparr[1]] == -1 && bike[temparr[2]] == -1) {
                    worker[temparr[1]] = temparr[2];
                    bike[temparr[2]] = temparr[1];
                    assigned++;
                }
            }
            return worker;
        }*/
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            // Notice that the Manhattan distance is between 0 and 2000,
            // which means we can sort easily without even using priority queue
            int w = workers.length, b = bikes.length;
            int[] wo = new int[w], bi = new int[b];
            List<int[]>[] dists = new List[2001];
            Arrays.fill(wo, -1);
            Arrays.fill(bi, -1);
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < b; j++) {
                    int[] worker = workers[i];
                    int[] bike = bikes[j];
                    int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                    if (dists[dist] == null) {
                        dists[dist] = new ArrayList<int[]>();
                    }
                    dists[dist].add(new int[]{i, j});
                }
            }
            int assigned = 0;
            for (int i = 0; i <= 2000 && assigned < w; i++) {
                if (dists[i] == null) continue;
                for (int[] pair : dists[i]) {
                    if (wo[pair[0]] == -1 && bi[pair[1]] == -1) {
                        wo[pair[0]] = pair[1];
                        bi[pair[1]] = pair[0];
                        assigned++;
                    }
                }
            }
            return wo;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
        * [[0,0],[1,1],[2,0]]
        * [[1,0],[2,2],[2,1]]
        * */
        int[][] workers = {{0,0},{1,1},{2,0}};
        int[][] bikes = {{1,0},{2,2},{2,1}};
//        int[][] workers = {{0,0},{2,1}};
//        int[][] bikes = {{1,2},{3,3}};
        int[] assignBikes = solution.assignBikes(workers, bikes);
        System.out.println(Arrays.toString(assignBikes));
    }
}
