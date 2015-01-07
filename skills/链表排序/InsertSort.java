package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 插入排序
 * 直接交换节点，时间复杂度O（n^2）,空间复杂度O（1）
 */

public class InsertSort implements Solution {
    @Override
    public ListNode sort(ListNode head) {
        if (head == null)
            return head;

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = head, last = head.next;

        while (last != null) {
            if (prev.val <= last.val) {
                last = last.next;
                prev = prev.next;
            } else {
                head = start;
                while (head.next.val < last.val)
                    head = head.next;

                prev.next = last.next;
                last.next = head.next;
                head.next = last;
                last = prev.next;
            }
        }

        return start.next;
    }
}
