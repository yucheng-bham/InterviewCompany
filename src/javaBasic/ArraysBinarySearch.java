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
        /*int[] nums = {2,3,1,6,7};
        int len = Arrays.binarySearch(nums, 0, 3, 8);
        System.out.println(len);*/

        int[] nums1 = {-4, 2};
        int len1 = Arrays.binarySearch(nums1, 0, 2, 1);
        System.out.println(len1);

//        System.out.println(Arrays.toString(nums));
    }
}

