# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        p, pre, i = head, head, 0
        while p:
            if p.next and p.next.val == p.val:
                q = p.next
                while q and q.val == p.val:
                    q = q.next
                p = q
            else:
                if i == 0:
                    head, pre = p, p
                else:
                    pre.next, pre = p, p
                p = p.next
                i += 1
        if i:
            pre.next = p
            return head
        else:
            return None
def creatList(a):
    l = ListNode(a[0])
    p = l
    for i in a[1:]:
        node = ListNode(i)
        p.next = node
        p = p.next
    return l

def printList(l):
    while l:
        print l.val
        l = l.next

a = [1,2,2]
head = creatList(a)
solution = Solution()
print printList(solution.deleteDuplicates(head))