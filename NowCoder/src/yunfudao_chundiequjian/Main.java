package yunfudao_chundiequjian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-8-1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] intervals = new int[m * 2][2];
        for (int i = 0; i < m * 2; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = i % 2 == 0 ? 0: 1;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int res = 0, count = 0;
        for (int[] interval: intervals) {
            if (interval[1] == 0) {
                count ++;
            } else{
                count--;
            }
            res = Math.max(res, count);
        }
        System.out.println(res);
    }
}
