package javaBasic;

import java.util.Arrays;

/**
 * The class is 数组二分查找。
 *
 * @author YuCheng
 * @version 2020/1/1 14:45
 */
public class ArraysBinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,3,1,6,7};
        int len = Arrays.binarySearch(nums, 0, 3, 8);
        System.out.println(len);
//        System.out.println(Arrays.toString(nums));
    }
}

