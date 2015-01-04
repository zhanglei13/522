# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        if m == n:
            return head
        q, p, start, end =head, head, m, n - m
        while start > 1:
            q, p = p, p.next
            start -= 1
        pre, l = p, p.next
        while end > 0:
            nex = l.next
            l.next = pre
            pre = l
            l = nex
            end -= 1
        if m == 1:
            p.next = l
            return pre
        else:
            q.next, p.next = pre, l
            return head

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

a, m, n = [1,2,3,4,5], 2, 4
head = creatList(a)
solution = Solution()
print printList(solution.reverseBetween(head, m, n))