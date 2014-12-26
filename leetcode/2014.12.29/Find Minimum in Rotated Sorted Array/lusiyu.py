class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        l, r = 0, len(num)-1
        while l < r:
            if num[l] < num[r]:
                return num[l]
            else:
                mid = l + r >> 1
                if num[mid] > num[r]:
                    l = mid + 1
                else:
                    r = mid
        if l == r:
            return num[l]
solution = Solution()
num = [4, 5, 6, 7, 0, 1]
print solution.findMin(num)