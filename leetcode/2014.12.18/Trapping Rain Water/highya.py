def trap(A):
	crest=[]
	crest1=[]
	water=0
	B=[]
	B.append(0)
	B.append(A[0])
	for i in range(1,len(A)):
		if A[i]!=A[i-1]:
			B.append(A[i])
	B.append(0)
	for i in range(1,len(B)):
		if B[i]>B[i-1] and B[i]>B[i+1]:
			crest.append([B[i],i] )
	crest1.append(crest[0])
	for i in range(1,len(crest)-1):
		if crest[i][0]>crest[i+1][0] or crest[i][0]>crest[i-1][0]:
			crest1.append(crest[i])
	crest1.append(crest[len(crest)-1])
	for i in range(1,len(crest1)):
		height=min(crest1[i][0],crest1[i-1][0])	
		length=crest1[i][1]-crest1[i-1][1]-1
		no_water=0
		for j in range(crest1[i-1][1]+1,crest1[i][1]):
			if B[j]>height:
				B[j]=height
			no_water+=B[j]
		print height,length,no_water
		water+=height*length-no_water
	print water
	return water


