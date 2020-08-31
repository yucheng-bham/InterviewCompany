package alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] aT = new int[T];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int res = 0;
            int[] a = new int[n];
            for (int j = 0; j < n; j++) a[j] = sc.nextInt();
            Arrays.sort(a);

            while (n > 3) {
                res += Math.min(2 * a[0] + a[n - 1] + a[n - 2],
                        a[0] + 2 * a[1] + a[n - 1]);
                n -= 2;
            }
            if (n < 3) {
                res += a[n - 1];
            } else if (n == 3) {
                res += a[0] + a[1] + a[2];
            }
            aT[i] = res;
        }
        for (int ans: aT) System.out.println(ans);

    }
}
