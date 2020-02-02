package interview.dynamicProgramming.LeetCode_132;

import javax.sound.midi.Soundbank;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/5 10:48
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int minCut = solution.minCut("aab");
        int minCut = solution.minCut("baaaa");
        System.out.println(minCut);
    }
}
class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
