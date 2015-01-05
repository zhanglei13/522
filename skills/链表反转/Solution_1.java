package list;

public class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = head, current = prev.next, last;
        head.next = null;

        while (current != null) {
            last = current.next;
            current.next = prev;
            prev = current;
            current = last;
        }

        return prev;
    }
}
