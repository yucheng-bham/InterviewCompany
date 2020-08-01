package interview.practice;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-3-7
 */
public class Solution {
    public static void main(String[] args) {
        Ssolution ssolution = new Ssolution();
        int largeestPerimeter = ssolution.largeestPerimeter(new int[]{1, 2, 2});
        System.out.println(largeestPerimeter);
    }
}
class Ssolution{
    public int largeestPerimeter(int[] A) {
        int a = A[0];
        int b = A[1];
        int c = A[2];
        double s = (a + b + c) / 2.0;
        return (int)Math.sqrt(s* (s - a) * (s - b) * (s - c));
    }
}
