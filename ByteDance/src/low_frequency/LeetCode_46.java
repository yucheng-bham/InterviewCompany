package low_frequency;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_46 {
    static class Solution {
        // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        /*public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, nums, 0, new ArrayList<>());
            return res;
        }
        public void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> temp) {
            // if (!res.contains(temp)) {
            res.add(new ArrayList<>(temp));
            // }
            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                helper(res, nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }

        }*/
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, nums, new ArrayList<>(), new boolean[nums.length]);
            return res;
        }
        public void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
            if (temp.size() == nums.length) {
                res.add(new ArrayList<>(temp));
            } else
                for (int i = 0; i < nums.length; i++) {
                    if (!visited[i]) {
                        temp.add(nums[i]);
                        visited[i] = true;
                        helper(res, nums, temp, visited);
                        visited[i] = false;
                        temp.remove(temp.size() - 1);
                    }
                }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1,5,2,3};
//        int[] nums = {1,1,2,3};
        int[] nums = {1,3,2,0};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
