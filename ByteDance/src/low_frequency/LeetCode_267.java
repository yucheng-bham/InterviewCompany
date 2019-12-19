package low_frequency;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_267 {
    static class Solution {
        // 这也是一个递归剪枝的思想的体现；就是在我们递归中for（）循环里，使用map[i] == 0 continue;相对于是本来128！的算法可以将时间复杂度缩小到    （n/ 2）! n就是不同的
        public List<String> generatePalindromes(String s) {
            char[] chs = s.toCharArray();
            List<String> res = new ArrayList<>();
            int[] map = new int[128];
            for (char c: chs) {
                map[c]++;
            }
            int count = 0;
            char core = ' ';
            for (int i = 0; i < 128; i++) {
                if (map[i] % 2 == 0) continue;
                if (++count > 1) return res;
                core = (char)(i);
                map[i]--;
            }
            String str = (core == ' ') ? "": "" + core;
            helper(res, chs, str, map);
            return res;
        }
        public void helper(List<String> res, char[] chs, String str, int[] map) {
            if (str.length() == chs.length) {
                res.add(str);
            } else {
                for (int i = 0; i < 128 ; i++) {
                    if (map[i] == 0 ) continue;
                    map[i] -= 2;
                    char temp = (char)( i);
                    helper(res, chs, temp + str + temp, map);
                    map[i] +=2;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> palindromes = solution.generatePalindromes("aabbccc");
//        List<String> palindromes = solution.generatePalindromes("aabbccccc");
        System.out.println(palindromes.size());
        System.out.println(palindromes);
    }
}
