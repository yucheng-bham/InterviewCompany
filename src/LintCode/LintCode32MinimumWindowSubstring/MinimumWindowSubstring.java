package LintCode.LintCode32MinimumWindowSubstring;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/1 21:08
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String minWindow = solution.minWindow("abc", "ac");
        System.out.println(minWindow);
    }
}
class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        int[] tmap = new int[256];
        int[] smap = new int[256];
        for (char c : target.toCharArray()) {
            tmap[c]++;
        }
        int j = 0;
        int len = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && valid(smap, tmap)) {
                smap[source.charAt(j)]++;
                j++;
            }
            if (valid(smap, tmap)) {
                if (len > j - i) {
                    res = source.substring(i, j);
                    len = j - i;
                }
            }
            smap[source.charAt(i)]--;
        }
        return res;
    }
    private boolean valid(int[] smap, int[] tmap) {
        for (int i = 0; i < 256; i++) {
            if (tmap[i] > smap[i]) return false;
        }
        return true;
    }
}
