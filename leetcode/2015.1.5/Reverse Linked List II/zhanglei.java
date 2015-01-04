public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(0);
        ListNode result = first;
        first.next = head;
        ListNode p = head, q;

        for (int i = 1; i < m; i++) {
            first = first.next;
            p = p.next;
        }

        for (int i = 0; i < n - m; i++) {
            q = p.next;
            p.next = q.next;
            q.next = first.next;
            first.next = q;
        }

        return result.next;
    }
}