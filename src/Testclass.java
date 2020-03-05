import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-2-16
 */
public class Testclass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr =
                {-2147483648,-2147483648,2147483647,
                        -2147483648, -2147483648,-2147483648,
                        2147483647,2147483647,2147483647,
                        2147483647,-2147483648,2147483647,
                        -2147483648};
        double[] medianSlidingWindow = solution.medianSlidingWindow(arr, 3);
        int i = 0;
        for (double d: medianSlidingWindow) {
            System.out.println(i++ + ":" + d);
        }
    }
}
class Node implements Comparable<Node>{
    int id;
    int val;
    public Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
    public int compareTo(Node a) {
//        if (this.val == a.val) return this.id - a.id;
        return this.val > a.val ? 1:
                this.val < a.val ? -1:
                this.id - a.id;
    }
}
class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new double[0];
        int n = nums.length;
        if (k == 0) return new double[n];
        double[] res = new double[n - k + 1];
        TreeSet<Node> maxheap = new TreeSet<>();
        TreeSet<Node> minheap = new TreeSet<>();
        int half = (k + 1) / 2;
        for (int i = 0; i < k - 1; i++) {
            addnum(maxheap, minheap, half, new Node(i, nums[i]));
        }
        for (int i = k - 1; i < n; i++) {
            addnum(maxheap, minheap, half, new Node(i, nums[i]));
            res[i - k + 1] = findMedian(maxheap, minheap);
            removenum(maxheap, minheap, new Node(i - k + 1, nums[i - k + 1]));
        }
        return res;
    }
    public void addnum(TreeSet<Node> maxheap, TreeSet<Node> minheap, int size, Node num) {
        if (maxheap.size() < size) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }
        if (maxheap.size() == size) {
            if (minheap.size() > 0 && maxheap.last().val > minheap.first().val) {
                Node maxn = maxheap.last();
                Node minn = minheap.first();
                maxheap.remove(maxn);
                minheap.remove(minn);
                maxheap.add(minn);
                minheap.add(maxn);
            }
        }
    }
    public void removenum(TreeSet<Node> maxheap, TreeSet<Node> minheap, Node num) {
        if (maxheap.contains(num)) {
            maxheap.remove(num);
        } else {
            minheap.remove(num);
        }
    }
    public double findMedian(TreeSet<Node> maxheap, TreeSet<Node> minheap) {
        if (maxheap.size() != minheap.size()) {
            return maxheap.last().val;
        } else {
            return ((double)maxheap.last().val + (double)minheap.first().val) / 2.0;
        }
    }

}
