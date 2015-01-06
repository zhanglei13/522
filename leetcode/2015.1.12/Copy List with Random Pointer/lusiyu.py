# Definition for singly-linked list with a random pointer.
# class RandomListNode:
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
        if head == None:
            return None
        newhead = RandomListNode(0)
        cur, newcur, pre, nextMap = head, newhead, None, {}
        while cur:
            nextMap[cur] = cur.next
            newcur.next = RandomListNode(cur.label)
            newcur = newcur.next
            newcur.random = cur
            pre, cur = cur, cur.next
            pre.next = newcur
        newcur = newhead.next
        while newcur:
            newcur.random = newcur.random.random.next if newcur.random.random else None
            newcur = newcur.next
        cur = head
        while cur:
            cur.next = nextMap[cur]
            cur = cur.next
        return newhead.next