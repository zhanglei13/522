class Solution:
# @return a list of lists of length 3, [[val1,val2,val3]]   
    def threeSum(self, num):
        num.sort()
        dct, ans = {}, []
        for i in range(0, len(num)):
            if (i > 0 and num[i] == num[i-1]):
                continue
            l, r = i + 1, len(num) - 1
            while l < r:
                ssum = num[l] + num[r] + num[i]
                if ssum == 0:
                    ans.append([num[i], num[l], num[r]])
                    while l < r and num[l] == num[l + 1]: 
                        l = l + 1
                    while l < r and num[r] == num[r - 1]: 
                        r = r - 1
                    l, r = l + 1, r - 1
                elif ssum < 0:
                    l = l + 1
                else:
                    r = r - 1
        return ans



'''test
sol=Solution()
a=[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
print sol.threeSum(a)
'''
