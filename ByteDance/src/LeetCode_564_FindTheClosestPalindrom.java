/**
 * The class
 *
 * @author YuCheng
 * @version 2020-3-3
 */
public class LeetCode_564_FindTheClosestPalindrom {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 10987 1098 1 123
        String nearestPalindromic = solution.nearestPalindromic("10987");

        System.out.println(nearestPalindromic);
    }
}
class Solution {
    public String nearestPalindromic(String n) {
        int order = (int) Math.pow(10, n.length()/2);
        Long ans = Long.valueOf(new String(n));
        Long noChange = mirror(ans);

        Long larger = mirror((ans/order)*order + order+1);
        Long smaller = mirror((ans/order)*order - 1 );

        if ( noChange > ans) {
            larger = (long) Math.min(noChange, larger);
        } else if ( noChange < ans) {
            smaller = (long) Math.max(noChange, smaller);
        }
        return String.valueOf( ans - smaller <= larger - ans ? smaller :larger) ;
    }
    Long mirror(Long ans) {
        char[] a = String.valueOf(ans).toCharArray();
        int i = 0;
        int j = a.length-1;
        while (i < j) {
            a[j--] = a[i++];
        }
        return Long.valueOf(new String(a));
    }


}



