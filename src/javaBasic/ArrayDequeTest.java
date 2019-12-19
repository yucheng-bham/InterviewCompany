package javaBasic;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q);
        q.pop();
        System.out.println(q);
        q.clear();
        System.out.println(q);
        q.offer(123);
        System.out.println(q);
    }
}
