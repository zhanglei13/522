package sort;

import java.util.List;

/**
 * Created by zhanglei on 2015/1/7.
 * 选择排序
 * 交换节点的val值，时间复杂度O（n^2）,空间复杂度O（1）
 */

public class SelectSort implements Solution {
    @Override
    public ListNode sort(ListNode head) {
        if (head == null)
            return head;

        ListNode result = head, minNode, current;

        while (head.next != null) {
            minNode = head;

            for (current = head.next; current != null; current = current.next) {
                if (current.val < minNode.val)
                    minNode = current;
            }

            int temp = head.val;
            head.val = minNode.val;
            minNode.val = temp;
            head = head.next;
        }

        return result;
    }
}