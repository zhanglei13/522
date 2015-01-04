# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        bitsum = l1.val + l2.val
        listNode, bitadd, p, q = ListNode(bitsum % 10), bitsum / 10, l1.next, l2.next
        l = listNode
        while p and q:
            bitsum = p.val + q.val  + bitadd
            node = ListNode(bitsum % 10)
            bitadd = bitsum / 10
            l.next = node
            l, p, q = l.next, p.next, q.next
        while p:
            bitsum = p.val + bitadd
            node = ListNode(bitsum % 10)
            bitadd = bitsum / 10
            l.next = node
            l, p = l.next, p.next
        while q:
            bitsum = q.val + bitadd
            node = ListNode(bitsum % 10)
            bitadd = bitsum / 10
            l.next = node
            l, q = l.next, q.next        
        if bitadd == 1:
            node = ListNode(1)
            l.next = node
        return listNode

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

a, b = [2, 4, 3, 1], [5, 6, 4]
l1, l2 = creatList(a), creatList(b)
solution = Solution()
printList(solution.addTwoNumbers(l1, l2))
