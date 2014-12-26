class Solution:
    # @param A, a list of integers
    # @param target, an integer to be inserted
    # @return integer
    def searchInsert(self, A, target):
        l, r = 0, len(A)-1
        while l <= r:
            mid = l + r >> 1
            if A[mid] == target:
                return mid
            elif A[mid] > target:
                r -= 1
            else:
                l += 1
        return l
A, target = [1, 3, 5, 6], 7
solution = Solution()
print solution.searchInsert(A, target)
