import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int total = n - 1;
        int[] t = new int[50001];
        Map<Integer, List<Integer>> tcontain = new HashMap<>();
        int x, y;
        for (int i = 0; i < n - 1; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            t[y] = t[x] + 1;
            if (!tcontain.containsKey(x)) {
                tcontain.put(x, new ArrayList<>());
            }
            tcontain.get(x).add(y);
        }
        int depth = 0;
        for (int i = 1; i <= n; i++) {
            depth = Math.max(depth, t[i]);
        }
        if (tcontain.get(start).contains(end)) {
            System.out.println(depth - t[start]);
        } else {
            System.out.println(depth + t[start]);
        }

    }
}




