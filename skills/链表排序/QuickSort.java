package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 快速排序
 * 交换节点的val值，平均时间复杂度O（nlogn）,不考虑递归栈空间的话空间复杂度是O（1）
 */

public class QuickSort implements Solution {
    @Override
    public ListNode sort(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode mid = partition(head, tail);
            quickSort(head, mid);
            quickSort(mid.next, tail);
        }
    }

    private ListNode partition(ListNode low, ListNode high) {
        int pivot = low.val;
        ListNode ptr = low;

        for (ListNode current = low.next; current != high; current = current.next) {
            if (current.val < pivot) {
                ptr = ptr.next;
                swap(current, ptr);
            }
        }
        swap(ptr, low);

        return ptr;
    }

    private void swap(ListNode p, ListNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}
