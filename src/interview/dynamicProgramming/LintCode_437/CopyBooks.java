package interview.dynamicProgramming.LintCode_437;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/1/7 15:42
 */
public class CopyBooks {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 4};
        int copyBooks = solution.copyBooks(arr, 2);
        System.out.println(copyBooks);
    }
}
class Solution {
    /**
     * @param A: an array of integers
     * @param K: An integer
     * @return: an integer
     */
    public int copyBooks(int[] A, int K) {
        // write your code here
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (K > n) {
            K = n;
        }
        int[][] f = new int[K + 1][n + 1];
        // int i, j, k, s;
        // no person copy the book
        for (int i = 1; i <= n; i++) {
            f[0][i] = Integer.MAX_VALUE;
        }
        // no person copy no book
        f[0][0] = 0;
        int s = 0;
        // ith person copy the j book
        for (int k = 1; k <= K; k++) {
            f[k][0] = 0;
            // copy first j books
            for (int i = 1; i <= n; i++) {
                f[k][i] = Integer.MAX_VALUE;
                s = 0;
                for (int j = i; j >= 0 ; --j) {
                    // s = A[j] +.....+ A[i - 1]
                    if (f[k - 1][j] != Integer.MAX_VALUE)
                        f[k][i] = Math.min(f[k][i], Math.max(f[k - 1][j], s));
                    // update s
                    if (j > 0)
                        s += A[j - 1];
                }

            }
        }
        return f[K][n];
    }
}

