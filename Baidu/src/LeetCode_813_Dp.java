public class LeetCode_813_Dp {
    static class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            int N = A.length;
            double[] P = new double[N+1];
            for (int i = 0; i < N; ++i)
                P[i+1] = P[i] + A[i];

            double[][] dp = new double[N][K];
//            double[] dp = new double[N];

            for (int i = 0; i < N; ++i)
//                dp[i] = (P[N] - P[i]) / (N - i);
                dp[i][0] = (P[N] - P[i]) / (N - i);

//            for (int k = 0; k < K-1; ++k)
            for (int k = 1; k < K; ++k)
                for (int i = 0; i < N; ++i)
                    for (int j = i+1; j < N; ++j)
                        dp[i][k] = Math.max(dp[i][k], (P[j]-P[i]) /(j-i) + dp[j][k - 1]);
//                        dp[i] = Math.max(dp[i], (P[j]-P[i]) /(j-i) + dp[j]);

            return dp[0][K - 1];
//            return dp[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9,1,2,3,9};
        double largestSumOfAverages = solution.largestSumOfAverages(arr, 3);
        System.out.println(largestSumOfAverages); // ans = 20.0
    }
}
