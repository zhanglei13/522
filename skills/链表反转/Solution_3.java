package list;

public class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev, last;
        prev = head.next;
        last = reverse(head.next);
        prev.next = head;
        head.next = null;

        return last;
    }
}
