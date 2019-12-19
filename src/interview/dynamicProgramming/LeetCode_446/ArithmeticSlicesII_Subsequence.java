package interview.dynamicProgramming.LeetCode_446;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2019/12/18 11:41
 */
public class ArithmeticSlicesII_Subsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 2, 3, 4};
        int i = solution.numberOfArithmeticSlices(arr);
        System.out.println(i);
    }
}
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)A[i] - (long)A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int)ans;
    }
}
