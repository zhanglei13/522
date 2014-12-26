class Solution:
	def fourSum(self,num,target):
		ans=[]
		if len(num)<4:
			return []
		num.sort()
		for l1 in range(len(num)):
			l2,r1,r2=l1+1,len(num)-2,len(num)-1
			while l2<r1:
				ssum=num[l1]+num[l2]+num[r1]+num[r2]
				if ssum  == target:
					ans.append([num[l1],num[l2],num[r1],num[r2]])
					while l2<r1 and num[l2]==num[l2+1]:
						l2+=1
					while l2<r1 and num[r1]==num[r1-1]:
						r1-=1
					l2,r1=l2+1,r1-1
				elif ssum<target:
					if l2-l1==1:
						l2+=1
					else:
						l1+=1
				elif ssum>target:
					if r2-r1==1:
						r1-=1
					else:
						r2-=1
		return ans
