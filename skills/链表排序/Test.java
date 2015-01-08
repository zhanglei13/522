package sort;

public class Test {
    public static void main(String[] args) {
        //  int[] num = {};
        int[] num = {1, 49, 38, 65, 97, 76, 1, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        ListNode head = createList(num);
        Solution solution = new MergeSort();
        printList(solution.sort(head));
    }

    private static ListNode createList(int[] num) {
        ListNode head = new ListNode(0);
        ListNode result = head;

        for (int i : num) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = head.next;
        }

        return result.next;
    }

    private static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
