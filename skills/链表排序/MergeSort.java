package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 归并排序
 * 交换链表节点，时间复杂度O（nlogn）,不考虑递归栈空间的话空间复杂度是O（1）
 * 最好和最坏时间复杂度都是nlogn，最适合单链表的排序方式
 */

public class MergeSort implements Solution {
    @Override
    public ListNode sort(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 选定两指针，一个以2为步长，一个1为步长，得到mid
        ListNode prev = head, last = head;
        while (last.next != null && last.next.next != null) {
            last = last.next.next;
            prev = prev.next;
        }
        last = prev;
        prev = prev.next;
        last.next = null;

        head = mergeSort(head);
        prev = mergeSort(prev);
        return merge(head, prev);
    }

    private ListNode merge(ListNode prev, ListNode last) {
        ListNode current = new ListNode(0);
        ListNode result = current;

        while (prev != null && last != null) {
            if (prev.val <= last.val) {
                current.next = prev;
                prev = prev.next;
            } else {
                current.next = last;
                last = last.next;
            }
            current = current.next;
        }

        if (prev != null)
            current.next = prev;
        if (last != null)
            current.next = last;

        return result.next;
    }
}
