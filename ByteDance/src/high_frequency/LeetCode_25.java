package high_frequency;

import StructureLeetCode.ListNode;

public class LeetCode_25 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        /* public ListNode reverseKGroup(ListNode head, int k) {
             ListNode preNext = head;
             ListNode next = head;
             int step = k;
             while (next != null && step > 0) {
                 preNext = next;
                 next = next.next;
                 step--;
             }
             if (step > 0) return head;
             preNext.next = null;

             ListNode pre = reverseKGroup(next, k);
             ListNode cur = head;
             while (cur != null) {
                 ListNode curNext = cur.next;
                 cur.next = pre;
                 pre = cur;
                 cur = curNext;
             }
             return pre;
         }*/
        public ListNode reverseKGroup(ListNode head, int k) {
            // 优化的代码
            ListNode cur = head;
            int count = 0;
            while (cur != null && count != k) {
                cur = cur.next;
                count++;
            }
            if (count == k) {
                ListNode pre = reverseKGroup(cur, k);
                while (head != cur) {
                    ListNode next = head.next;
                    head.next = pre;
                    pre = head;
                    head = next;
                }
                return pre;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = ListNode.createListNode(arr);
        ListNode resultNode = solution.reverseKGroup(head, 3);
        while (resultNode != null) {
            System.out.print(resultNode.val + " -> ");
            resultNode = resultNode.next;
        }
        System.out.print(resultNode);
    }

}
