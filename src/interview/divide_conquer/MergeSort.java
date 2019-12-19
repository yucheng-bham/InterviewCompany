package interview.divide_conquer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.scene.Scene;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,6,1};
        int[] arr2 = {7,8};
        int[] nums = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, nums, 0, arr1.length);
//        System.arraycopy(arr1, 0, nums, 0, -1);
//        System.arraycopy(arr1, 0, nums, 0, 7);
        System.arraycopy(arr2, 0, nums, arr1.length, arr2.length);
        System.out.println(Arrays.toString(nums));
        int[] target = mergesort1(nums);
        System.out.println(Arrays.toString(target));
//        mergesort2(nums);
//        System.out.println(Arrays.toString(nums));
    }

    private static void mergesort2(int[] nums) {
//        mergehalve(nums, 0, nums.length - 1);
    }

    private static int[] mergesort1(int[] nums) {
        int[] temp = new int[nums.length];
        mergehalve(nums, 0, nums.length - 1, temp);
        return temp;
    }

    private static void mergehalve(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergehalve(nums, left, mid, temp);
        mergehalve(nums, mid + 1, right, temp);
        mergesort(nums,left, right, temp);
    }

    private static void mergesort(int[] nums, int left, int right, int[] temp) {
        int lefstart = left;
        int leftend = left + (right - left) / 2;
        int rightstart = leftend + 1;
        int rightend = right;

        int index = left;
        while (lefstart <= leftend && rightstart <= rightend) {
            if (nums[lefstart] < nums[rightstart]) {
                temp[index++] = nums[lefstart++];
            } else {
                temp[index++] = nums[rightstart++];
            }
        }
        if (lefstart > leftend)
            System.arraycopy(nums,rightstart,temp,index, rightend - rightstart + 1);
        if (rightstart > rightend)
            System.arraycopy(nums,lefstart,temp,index, leftend - lefstart + 1);
        System.arraycopy(temp,left,nums,left,right - left + 1);

    }
}
