package javaBasic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-3-5
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList(1,2,3,5,6,4));
        set.remove(2);
        set.add(2);
        Iterator<Integer> setiter = set.iterator();
        while (setiter.hasNext()) {
            System.out.print(setiter.next() + "\t" );
        }
        System.out.println();
        System.out.println("----------------");
        System.out.println();

        HashSet<Integer> set2 = new HashSet<>();
        set2.addAll(Arrays.asList(1,2,3,5,6,4));
        set2.remove(2);
        set2.add(2);
        Iterator<Integer> set2iter = set2.iterator();
        while (set2iter.hasNext()) {
            System.out.print(set2iter.next() + "\t");
        }
    }
}
