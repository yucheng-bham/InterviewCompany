package javaBasic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
       /* Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        pq.offer(6);
        pq.offer(99);
        pq.offer(81);
//        pq.remove(0);
        System.out.println(pq);
//        pq.remove(6);
        while (!pq.isEmpty()) {
            Integer peek = pq.remove();
            System.out.println(peek);
        }

        Queue<Integer> qtest = new PriorityQueue<>((a, b) -> (a- b));
        qtest.offer(12);
        qtest.offer(43);
        qtest.offer(3);
        System.out.println(qtest);
        while (!qtest.isEmpty()) {
            System.out.println(qtest.poll());
        }*/
        Comparator<int[]> cmp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[]  b) {
                return a[0] - b[0];
            }
        };
//        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        pq.offer(arr1);
        int[] arr0 = new int[]{0, 1};
        pq.offer(arr0);
        int[] arr2 = new int[]{2, 1, 4, 7};
        pq.offer(arr2);
        while (!pq.isEmpty()) {
            int[] temparr = pq.poll();
            System.out.println(Arrays.toString(temparr));
        }
    }
}
