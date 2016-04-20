def partition(pivot,s): 
    left, right = [], [] 
    for x in s: 
        if x <= pivot: 
            left.append(x) 
        else: 
            right.append(x) 
    return left, right
    
def oriqsort(s):
    if len(s)>1:
        pivot=s[0]
        (left,right)=partition(pivot,s[1:])
        return oriqsort(left+[pivot])+oriqsort(right)
    else: 
        return s

def qsort(s):
    if(len(s)>1):
        pivot=s[0]
        pivotIdx=0
        leng = len(s)
        lengD = leng//2
        for i in range(0,leng):
            if(s[i]<=pivot):
                pivotIdx +=1
        pivotIdx -=1
        s[0],s[pivotIdx] = s[pivotIdx],s[0]
        for k in range(0,pivotIdx):
            print(pivotIdx,len(s))
            for i in range(pivotIdx+1,len(s)):
                if(s[i]<=pivot):
                    s[k],s[i] = s[i],s[k]
        s= qsort(s[:pivotIdx])+qsort([s[pivotIdx]])+qsort(s[pivotIdx+1:])
        return s
    else:
        return s
def msort(data):
    dataLen  = len(data)
    dataLenDiv = int(dataLen//2)
    for i in range(0,dataLen+2): #반복 횟수가 length/2 이지만 수가 많아질 경우를 고려
        for j in range(0,dataLenDiv):
            if(data[j] > data[j+1]):
                data[j] , data[j+1] = data[j+1], data[j]
    
        for j in range(dataLenDiv,dataLen-1):
            if(data[j] > data[j+1]):
                data[j], data[j+1] = data[j+1] , data[j]
        checkData = data
        if(len(data)>1):
            data= msort(data[:dataLenDiv])+ msort(data[dataLenDiv:])
        isNeededContinue = False
        for j in range(0,len(data)):
           if(data[j] != checkData[j]):
               isNeededContinue=True
               break
        del checkData
        if(not isNeededContinue):
            break
       
    return data
print(msort([32,990,23,1000,3000,6000,170,310,18,999999,2000,7,11,99,700,55])) #[1,5,2,4,3]))