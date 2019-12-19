package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysToList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<int[]> ints = Arrays.asList(arr);
        List<Integer> integers = Arrays.asList(arr[3], arr[1], arr[2]);
        System.out.println(integers);

        List<List<Integer>> res = new ArrayList();
        res.add(Arrays.asList(arr[1],arr[2]));
        System.out.println(res);
        /*int[][] arrint = {{1,2}, {1,3}, {12, 3}, {3,5}};
        ArrayList<int[]> ints1 = new ArrayList<>(Arrays.asList(arrint[0]));
        System.out.println(ints1);

        Integer[][] arrInt = {{1,2}, {1,3}, {12, 3}, {3,5}};
        List<Integer> integers1 = Arrays.asList(arrInt[0]);
        System.out.println(integers1);*/
        /*Object[] objects = integers.toArray();
        System.out.println(Arrays.toString(objects));*/
    }
}
