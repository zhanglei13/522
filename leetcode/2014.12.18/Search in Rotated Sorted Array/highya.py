class Solution:
    # @param A, a list of integers
	# @param target, an integer to be searched
	# @return an integer
	def search(self, A, target):
		if len(A) == 0:
			return -1
		low=0
		high=len(A)-1
		while low<=high:
			mid=(low+high)>>1
			if A[mid]==target:
				return mid
			if A[low]<=A[mid]:
				if A[low] <=target and target <A[mid]:
					high=mid-1
				else:
					low=mid+1
			else:
				if A[mid]<target and target <=A[high]:
					low=mid+1
				else:
					high=mid-1
		return -1
