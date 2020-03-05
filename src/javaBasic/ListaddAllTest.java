package javaBasic;

import java.util.*;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/3/1 9:03
 */
public class ListaddAllTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
//        liststr.addAll(Arrays.asList(new Integer[]{1,2,3,4}));
//        list.addAll(Arrays.asList(new Integer[]{4,5,6,7}));
//        System.out.println(list);
//        System.out.println(liststr);


        List<int[]> ints = Arrays.asList(new int[]{1, 2, 4, 3});
        System.out.println(ints);
        List<Integer> intInteger1 = Arrays.asList(new Integer[]{1, 2, 3, 4});
        System.out.println(intInteger1);
        List<Integer> intInteger2 = Arrays.asList(4, 3, 1, 2);
        System.out.println(intInteger2);
        list1.addAll(intInteger1);
        list2.addAll(intInteger2);
        System.out.println(list1);
        System.out.println(list2);
        throw new IllegalArgumentException();
    }
}
