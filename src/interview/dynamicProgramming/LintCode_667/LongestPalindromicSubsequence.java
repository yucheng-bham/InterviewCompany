package interview.dynamicProgramming.LintCode_667;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/8 22:03
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int longestPalindromeSubseq = solution.longestPalindromeSubseq("bbbab");
        System.out.println(longestPalindromeSubseq);
    }
}
class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String ss) {
        // write your code here
        char[] s = ss.toCharArray();
        int n = s.length;
        if (n <= 1) return n;
        int[][] f = new int[n][n];
        // len = 1
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        // len = 2
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = (s[i] == s[i + 1]) ? 2: 1;
        }
        for (int len = 3; len <= n; len++) {
            // [i ,,, i + len - 1]
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                if (s[i] == s[j]) {
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[0][n - 1];
    }
}