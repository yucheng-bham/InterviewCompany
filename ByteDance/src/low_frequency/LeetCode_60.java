package low_frequency;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_60 {
    static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) list.add(i);
            int[] fac = new int[n ];
            fac[0] = 1;
            for (int i = 1; i < n; i++) fac[i] *= i;
            k--;
            StringBuilder sb = new StringBuilder();
            for (int i = n; i > 0; i--) {
                int digitIndex = k / fac[i - 1];
                sb.append(list.get(digitIndex));
                list.remove(digitIndex);
                k %= fac[i - 1];
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 4);
        System.out.println(permutation);
    }
}
