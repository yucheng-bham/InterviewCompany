package interview.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/15 23:29
 */
public class SlidingWindowMedian_480 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7,9,3,8,0,2,4,8,3,9};
        double[] medianSlidingWindow = solution.medianSlidingWindow(arr, 1);
        System.out.println(Arrays.toString(medianSlidingWindow));
    }
}
class Solution {
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null  || nums.length == 0) return new double[0];
        int n = nums.length;
        double[] res = new double[n - k + 1];
        maxheap = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            if (maxheap.isEmpty() || nums[i] <= maxheap.peek()) {
                maxheap.offer(nums[i]);
            } else {
                minheap.offer(nums[i]);
            }
            balance();

            if (i >= k) {
                if (nums[i - k] <= maxheap.peek()) {
                    maxheap.remove(nums[i - k]);
                } else {
                    minheap.remove(nums[i - k]);
                }
            }
            balance();
            if (i >= k - 1) {
                res[i - k + 1] = findMedian();
            }

        }
        return res;
    }
    public void balance() {
        if (maxheap.size() - minheap.size() > 1) {
            minheap.offer(maxheap.poll());
        }
        if (minheap.size() - maxheap.size() > 1) {
            maxheap.offer(minheap.poll());
        }
    }
    public double findMedian() {
        if (maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else if (maxheap.size() < minheap.size()) {
            return minheap.peek();
        } else {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
    }
}
