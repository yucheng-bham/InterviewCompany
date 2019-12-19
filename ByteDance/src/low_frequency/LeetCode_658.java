package low_frequency;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_658 {
    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0, right = arr.length - k;
            while (left < right) {
                int mid = (left + right) / 2;
                if (x - arr[mid] > arr[mid + k] - x)
                    left = mid + 1;
                else
                    right = mid;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                res.add(arr[left++]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {1,2, 4, 6, 7};
//        int[] arr = {1,1,2,2,2,2,2,3,3};
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        List<Integer> closestElements = solution.findClosestElements(arr, 3, 5);
        System.out.println(closestElements);
    }
}
