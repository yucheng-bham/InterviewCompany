package leetcode_1094;

public class CarPooling {
//    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] capacityChanges = new int[1001];
            for (int i = 0; i < trips.length; i++) {
                capacityChanges[trips[i][1]] -= trips[i][0];
                capacityChanges[trips[i][2]] += trips[i][0];
            }

            for (int i = 0;i < capacityChanges.length;i++) {
                capacity += capacityChanges[i];
                if (capacity < 0) {
                    return false;
                }
            }
            return true;


        }
//    }

    public static void main(String[] args) {
        CarPooling cp = new CarPooling();
        boolean flag = cp.carPooling(new int[][]{{2,1,5}, {3,3,7}}, 5);
        System.out.println(flag);
    }
}
