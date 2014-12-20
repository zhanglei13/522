class Solution:
    def TwoSum(self,num,target):
        mmap={}
        for i in range(len(num)):
            if num[i] not in mmap:
                mmap[target-num[i]]=i
            else:
                return [num[mmap[num[i]]],num[i]]
        return -1
    
    def ThreeSum(self,num):
        if len(num)==0:
            return []
        tuple3=[]
        result=[]
        targetList=[]
        for i in range(len(num)):
            if num[0] in targetList:
                continue 
            targetList.append(num[0])
            target=num[0]
            num.pop(0)
            if self.TwoSum(num,-target) != -1:
                tuple3=self.TwoSum(num,-target)
                tuple3.append(target)
                tuple3.sort()
                if tuple3 not in result:
                    result.append(tuple3)                 
            num.append(target)
        return result        

sol=Solution()
a=[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
print sol.ThreeSum(a) 			
