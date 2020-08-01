package LeetCode_679_24GAME;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/19 22:29
 */
public class Lc_24Game {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 1, 8, 7};
        boolean judgePoint24 = solution.judgePoint24(arr);
        System.out.println(judgePoint24);
    }
}
class Solution {
    public boolean judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v: nums) A.add((double) v);
        return partition(A);
    }

    public boolean partition(ArrayList<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                // 选择其中任意两个进行运算
                //保证这两个不相等
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<>();
                    //对非被选中的，直接加入
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k!=j) {
                            nums2.add(nums.get(k));
                        }
                    }
                    //对被选中的运算
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        } else if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                        } else if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                        } else if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                        } else if (k == 3 && nums.get(j) != 0) {
                            nums2.add(nums.get(i) / nums.get(j));
                        } else {
                            continue;
                        }
                        if (partition(nums2)) {
                            return true;
                        }
                        //回退
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}


