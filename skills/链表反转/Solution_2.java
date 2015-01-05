package list;

public class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode current = prev.next, last;

        while (current.next != null) {
            last = current.next;
            current.next = last.next;
            last.next = prev.next;
            prev.next = last;
        }

        return prev.next;
    }
}
