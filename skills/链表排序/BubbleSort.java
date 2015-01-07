package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 冒泡排序
 * 交换链表节点val值，时间复杂度O（n^2）,空间复杂度O（1）
 */

public class BubbleSort implements Solution {
    @Override
    public ListNode sort(ListNode head) {
        ListNode flag = head;

        while (flag != null) {
            ListNode end = flag;
            flag = null;
            for (ListNode current = head; current.next != null; current = current.next) {
                if (current != head && current == end)
                    break;

                if (current.val > current.next.val) {
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                    flag = current;
                }
            }
        }

        return head;
    }
}
