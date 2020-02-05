package javaBasic;

import java.util.*;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/5 10:12
 */
public class SortTest {
    public static void main(String[] args) {
        /* list 可以使用两种方式来实现排序，一是list.sort(cmp)二是Collections.sort(list,cmp).
        对于（2）来说，collections.sort(list) 就是排序，类似Arrays.sort(arr)从小到大

         */
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(5);
        System.out.println(list);
        // list.sort
        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        System.out.println(list);
        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        System.out.println(list);
        // collections.sort()
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        System.out.println(list);*/
        // Arrays 只能sort包装类和类，对于基本数据类型是不能sort倒叙的
        Integer[] arr = new Integer[10];
        Random rad = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rad.nextInt(arr.length);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
