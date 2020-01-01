package interview.dynamicProgramming.LeetCode_5;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String longestPalindrome = solution.longestPalindrome("babad");
        System.out.println(longestPalindrome);

    }
}
class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = -1;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            // signle
            int singlelen = isPal(s, i, i);
            // double
            int doublelen = isPal(s, i, i + 1);
            int curlen = Math.max(singlelen, doublelen);
            if (curlen > len) {
                start = i - (curlen - 1) / 2;
                end = i + curlen  / 2;
                len = curlen;
            }
        }
        return s.substring(start, end + 1);
    }
    private int isPal(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}