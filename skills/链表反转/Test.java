package list;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = createList(nums);
        Solution solution = new Solution();
        printList(solution.reverse(head));
    }

    private static ListNode createList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode result = head;

        for (int i : nums) {
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
