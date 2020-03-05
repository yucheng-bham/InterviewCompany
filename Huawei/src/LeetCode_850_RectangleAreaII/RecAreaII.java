package LeetCode_850_RectangleAreaII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/24 10:24
 */
public class RecAreaII {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] arr = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
        int[][] arr = {{0,0,2,2},{1,0,2,3},{1,0,3,1},{1,1,3,3}};
        int rectangleArea = solution.rectangleArea(arr);
        System.out.println(rectangleArea);
    }
}
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][4];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> active = new ArrayList();
        int cur_y = events[0][0];
        long ans = 0;
        for (int[] event: events) {
            int y = event[0], typ = event[1], x1 = event[2], x2 = event[3];

            // Calculate query
            long query = 0;
            int cur = -1;
            for (int[] xs: active) {
                cur = Math.max(cur, xs[0]);
                query += Math.max(xs[1] - cur, 0);
                cur = Math.max(cur, xs[1]);
            }

            ans += query * (y - cur_y);

            if (typ == OPEN) {
                active.add(new int[]{x1, x2});
                Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                for (int i = 0; i < active.size(); ++i)
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
            }

            cur_y = y;
        }

        ans %= 1_000_000_007;
        return (int) ans;
    }
}


/* version 1
class Solution {
    public int rectangleArea(int[][] rectangles) {
        int N = rectangles.length;

        long ans = 0;
        for (int subset = 1; subset < (1<<N); ++subset) {
            int[] rec = new int[]{0, 0, 1_000_000_000, 1_000_000_000};
            int parity = -1;
            for (int bit = 0; bit < N; ++bit)
                if (((subset >> bit) & 1) != 0) {
                    rec = intersect(rec, rectangles[bit]);
                    parity *= -1;
                }
            ans += parity * area(rec);
        }

        long MOD = 1_000_000_007;
        ans %= MOD;
        if (ans < 0) ans += MOD;
        return (int) ans;
    }

    public long area(int[] rec) {
        long dx = Math.max(0, rec[2] - rec[0]);
        long dy = Math.max(0, rec[3] - rec[1]);
        return dx * dy;
    }

    public int[] intersect(int[] rec1, int[] rec2) {
        return new int[]{
                Math.max(rec1[0], rec2[0]),
                Math.max(rec1[1], rec2[1]),
                Math.min(rec1[2], rec2[2]),
                Math.min(rec1[3], rec2[3]),
        };
    }
}
*/

