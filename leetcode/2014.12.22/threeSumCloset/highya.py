def threeSumCloset(num,target):
    num.sort()
    ans=None
    for i in range(len(num)):
        l,r=i+1,len(num)-1
        while l<r:
            sum=num[i]+num[l]+num[r]
            if ans is None or abs(sum-target)<ans:
                ans=abs(sum-target)
                res=sum
            if sum<target:
                l+=1
            elif sum>target:
                r-=1
            else:
                return sum
    return res
