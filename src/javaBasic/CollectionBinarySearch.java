package javaBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/6/16 23:34
 */
public class CollectionBinarySearch {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        for (int i = 0; i < 5; i++) {
            int ran = i + new Random().nextInt(10);
            temp.add(ran);
        }
        Collections.sort(temp);
        System.out.println(temp);
        int index = Collections.binarySearch(temp, -100);
        System.out.println(index);


        /*for (int i = 0; i < 20; i++) {
            Random ran = new Random();
            int int_ran = ran.nextInt(5);
            temp.add(int_ran);
        }
        System.out.println(temp);*/
    }
}
