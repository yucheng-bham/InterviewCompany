package javaBasic;

import java.util.Arrays;

public class SystemTest {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
//        System.arraycopy(arr1, 1, arr1, 0, arr1.length - 1);
        int[] temp = new int[arr1.length - 1];
        System.arraycopy(arr1, 1, temp, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(temp));
    }
}
