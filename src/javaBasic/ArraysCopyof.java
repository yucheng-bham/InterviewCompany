package javaBasic;

import java.util.Arrays;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/6/18 10:33
 */
public class ArraysCopyof {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3,5};
        int[] copyarr = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(copyarr));
        int[] copyarr_1 = Arrays.copyOf(arr, 0);
        System.out.println(Arrays.toString(copyarr_1));
        int[] copyarr_3 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(copyarr_3));
        int[] copyarr_4 = Arrays.copyOf(arr, arr.length + 2);
        System.out.println(Arrays.toString(copyarr_4));

        int[] copyarr_2 = Arrays.copyOf(arr, -1);
        System.out.println(Arrays.toString(copyarr_2));
    }
}
