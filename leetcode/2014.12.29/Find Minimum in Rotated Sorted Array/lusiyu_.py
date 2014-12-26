class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        for i in range(len(num) - 1):
            if num[i] > num[i+1]:
                return num[i+1]
        return num[0]
solution = Solution()
num = [4, 5, 6, 7, 0, 1, 2]
print solution.findMin(num)