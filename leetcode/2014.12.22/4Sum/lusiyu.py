class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        num.sort()
        numLen, res = len(num), set()
        dic = {}
        for i in range(numLen):
            for j in range(i+1, numLen):
                if num[i]+num[j] not in dic:
                    dic[num[i]+num[j]] = [(i, j)]
                else:
                    dic[num[i]+num[j]].append((i, j))
        for i in range(numLen):
            for j in range(i+1, numLen):
                t = target - num[i] - num[j]
                if t in dic:
                    for k in dic[t]:
                        if k[0] > j:
                            res.add((num[i], num[j], num[k[0]], num[k[1]]))
        return [list(i) for i in res]
solution = Solution()
num, target = [1,0,-1,0,-2,2], 0
print solution.fourSum(num, target)