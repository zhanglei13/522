# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        p, q = head, head
        while p and q:
            p = p.next
            q = q.next.next if q.next else None
            if p and q and p == q:
                while head != p:
                    head = head.next
                    p = p.next
                return p
        return None