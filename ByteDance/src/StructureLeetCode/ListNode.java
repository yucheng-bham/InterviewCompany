package StructureLeetCode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode createListNode(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int element: arr) {
            ListNode node = new ListNode(element);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
