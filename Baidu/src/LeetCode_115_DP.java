import java.util.Arrays;

public class LeetCode_115_DP {
    static class Solution {
        public int numDistinct(String S, String T) {
            // array creation
            int[][] mem = new int[T.length()+1][S.length()+1];

            // filling the first row: with 1s
            for(int j=0; j<=S.length(); j++) {
                mem[0][j] = 1;
            }

            // the first column is 0 by default in every other rows but the first, which we need.

            for(int i=0; i<T.length(); i++) {
                for(int j=0; j<S.length(); j++) {
                    if(T.charAt(i) == S.charAt(j)) {
                        mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                    } else {
                        mem[i+1][j+1] = mem[i+1][j];
                    }
                }
            }

            return mem[T.length()][S.length()];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String strS = "rabbbit";
        String strT = "rabbit";
//        String strT = "it";
//        String strS = "ab";
//        String strT = "aab";

        int numDistinct = solution.numDistinct(strS, strT);
        System.out.println(numDistinct); // ans = 3. namely There are 3 rabbit
                                         // of StrT in the StrS rabbbit
    }
}
