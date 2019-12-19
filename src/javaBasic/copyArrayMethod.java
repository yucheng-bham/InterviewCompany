package javaBasic;

import java.util.Arrays;

public class copyArrayMethod {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        int[] ints = Arrays.copyOfRange(arr, 0, arr.length / 2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(arr));

        // This method does not have return value, so we need new array
        int[] newarr = new int[arr.length];
        System.arraycopy(arr,0,newarr, 0, arr.length/2);
        System.out.println(Arrays.toString(newarr));

        System.arraycopy(arr,0, arr, 1, arr.length/2);
        System.out.println(Arrays.toString(arr));
    }
}
