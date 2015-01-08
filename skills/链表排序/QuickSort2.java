package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 快速排序
 * 交换交换链表节点，平均时间复杂度O（nlogn）,不考虑递归栈空间的话空间复杂度是O（1）
 */

public class QuickSort2 implements Solution {
    @Override
    public ListNode sort(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        quickSort(start, head, null);
        return start.next;
    }

    private void quickSort(ListNode start, ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode mid = partition(start, head, tail);
            quickSort(start, start.next, mid);
            quickSort(mid, mid.next, tail);
        }
    }

    private ListNode partition(ListNode start, ListNode low, ListNode high) {
        int pivot = low.val;
        ListNode prev = low, last = low;
        ListNode current = low.next;

        while (current != high) {
            if (current.val < pivot) {
                last.next = current.next;
                current.next = prev;
                prev = current;
                current = last.next;
            } else {
                last = last.next;
                current = current.next;
            }
        }

        start.next = prev;
        return low;
    }
}
