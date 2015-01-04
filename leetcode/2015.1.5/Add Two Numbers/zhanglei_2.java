public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode current = l1;
        ListNode result = current;

        while (l1 != null) {
            int sum = l1.val + (l2 == null ? 0 : l2.val) + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            current = l1.next == null ? l1 : l1.next;
            l1 = l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (l2 != null)
            current.next = l2;

        ListNode last = current;
        while (carry != 0) {
            current = current.next;
            if (current == null) {
                last.next = new ListNode(1);
                break;
            }
            int sum = current.val + carry;
            current.val = sum % 10;
            carry = sum / 10;
            last = current;
        }

        return result;
    }
}