package interview.dynamicProgramming.LeetCode_10;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2019/12/19 11:00
 */
public class Regular_Expression_Matching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "aa";
        String pattern = "a*";
        boolean solutionMatch = solution.isMatch(text, pattern);
        System.out.println(solutionMatch);
    }
}
class Solution{
    public boolean isMatch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean first_match =
                        i < m && text.charAt(i) == pattern.charAt(j)
                        || pattern.charAt(j) == '.';
                if (j + 1 < n && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] ||
                                first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
/*
class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] =
                            dp[i][j+2] ||
                            first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match &&
                            dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
*/
