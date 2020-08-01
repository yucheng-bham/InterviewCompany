package high_frequency;

public class LeetCode_440 {
    static class Solution {
        public int findKthNumber(int n, int k) {
            int curr = 1;
            k = k - 1;
            while (k > 0) {
                int steps = calSteps(n, curr, curr + 1);
                if (steps <= k) {
                    curr += 1;
                    k -= steps;
                } else {
                    curr *= 10;
                    k -= 1;
                }
            }
            return curr;
        }

        //use long in case of overflow
        public int calSteps(int total, long n1, long n2) {
            int steps = 0;
            while (total >= n1) {
                steps += Math.min(total + 1, n2) - n1;
                n1 *= 10;
                n2 *= 10;
            }
            return steps;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.findKthNumber(124, 5));
        System.out.println(sol.findKthNumber(13, 7));
        // [1,  10, 11, 12, 13,     2, 3, 4, 5, 6, 7, 8, 9]
    }
}
