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
    def loop(s,offsetIndex,endIndex,isBeforePivot):
        if(len(s)>1 and offsetIndex<endIndex):
            pivot=s[offsetIndex]
            pivotIdx=0 #절대 인덱스
            leng = endIndex-offsetIndex+1 #len(s)
            lengD = leng//2
            for i in range(0,len(s)):
                if(s[i]<=pivot):
                    pivotIdx +=1
            pivotIdx -=1
            s[offsetIndex],s[pivotIdx] = s[pivotIdx],s[offsetIndex]
            checkData = s
            isNeededContinue = False
            for k in range(offsetIndex,pivotIdx):
                for i in range(pivotIdx+1,endIndex+1):
                    
                    if(s[i]<=pivot):
                        s[k],s[i] = s[i],s[k]
            loop(s,offsetIndex,pivotIdx-1,True)
            loop(s,pivotIdx+1,endIndex,False)
            """
            for j in range(0,len(s)):
                if(s[j] != checkData[j]):
                    isNeededContinue=True
                break
            del checkData
            if(not isNeededContinue):
                return s
            """
            return s
        else:
            return s
    return loop(s,0,len(s)-1,False)

def msort(data):
    def loop(data,offsetIndex,endIndex,beforeStartIndex,beforeEndindex,isBeforePivot,isFirstAccess,hasRequestReorder,mergeIndexCountControl):

        dataLen  = endIndex-offsetIndex+1
        dataLenDiv = int(dataLen//2)
        
        if(dataLen>1 and  beforeEndindex != -1 and beforeStartIndex != -1):
            loop(data,offsetIndex+dataLenDiv ,offsetIndex +dataLen-1,     offsetIndex,endIndex,False,False,False,(dataLen-dataLenDiv)//2)
            loop(data,offsetIndex, (offsetIndex+dataLenDiv-1)              ,offsetIndex,endIndex,True,False,False,(dataLen-dataLenDiv)//2 )
            return loop(data,offsetIndex,endIndex,-1,-1,False,False,True,(endIndex-offsetIndex+1)//2)
            #if (isFirstAccess):
                #return loop(data,offsetIndex,endIndex,-1,-1,False,False,True,(endIndex+1)//2)
            return data
        elif(hasRequestReorder):
            if(offsetIndex>=endIndex or dataLen < 0):
                return data
            else:
            
                midIdx = offsetIndex +mergeIndexCountControl #dataLenDiv
                #midIdx += mergeIndexCountControl
                
                print("beforeData: ",data[offsetIndex:offsetIndex+dataLen])
                print("bDr1: ",data[offsetIndex:midIdx])
                print("bDr2: ",data[midIdx:offsetIndex+dataLen])
                print(offsetIndex,midIdx,dataLen,dataLenDiv)
                if(data[offsetIndex:midIdx] != [] and data[midIdx:offsetIndex+dataLen] != []):
                    if(data[offsetIndex]>data[midIdx]):#offsetIndex에서 클때
                    #midIdx에서 작을때 dr2[0]을 팝 dr1길이 그대로
                        data[offsetIndex],data[offsetIndex+1:midIdx+1] = data[midIdx],data[offsetIndex:midIdx]
                    #최종적으로 현재 offsetIndex에서 작을때
                        mergeIndexCountControl = mergeIndexCountControl
                    else:
                    #offsetIndex에서 작을때
                    #dr1[0]을 팝 dr2길이 그대로
                        mergeIndexCountControl = mergeIndexCountControl -1
                if(dataLen-1<3):
                    mergeIndexCountControl= (dataLen-1)//2
                
                print("afterData: ",data[offsetIndex:offsetIndex+dataLen])
                print("~~~~~~~~~~~~~~~~~~~~~~~~")
                print("")
                return loop(data,offsetIndex+1,endIndex,-1,-1,False,False,True,mergeIndexCountControl)
                  
            return data
        else:
            
            if(isBeforePivot):
                return loop(data,beforeStartIndex,beforeEndindex,-1,-1,isBeforePivot,False,True,(beforeEndindex-beforeStartIndex+1)//2)
            return data
    return loop(data,0,len(data)-1,0,len(data)-1,False,True,False,-2)
    
print( msort([i for i in range(30,0,-1)])) #[777777,32,990,23,1000,3000,6000,170,310,18,999999,2000,7,11,99,700,55])) #[1,5,2,4,3]))


#original
"""
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
"""