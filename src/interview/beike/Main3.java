package interview.beike;
import java.util.Scanner;
public class Main3 {
    // 本题为考试多行输入输出规范示例，无需提交，不计分。


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int res = n, maxnum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cal = nums[i];
            for (int j = i; j < n; j++) {
                cal |= nums[j];
                System.out.print("现在的计算结果" + cal + " ");
                if (cal > maxnum ) {
                    res = j - i + 1;
                    maxnum = cal;
                } else if (cal == maxnum && j - i + 1 < res) {
                    res = j - i + 1;
                }
                System.out.println("最大值"+ maxnum);
            }
        }
        System.out.println(res);
    }
}
