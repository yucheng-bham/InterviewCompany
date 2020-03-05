package javaBasic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/26 10:17
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        String[] strint = new String[]{ "1", "2", "2", "3"};
        List<String> strings = Arrays.asList(strint);
        System.out.println(strings);
        q.addAll(strings);
        System.out.println(q);
    }
}
