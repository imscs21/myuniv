def qsort(s):
    print(s)
    if(len(s)>1):
        pivot=s[0]
        pivotIdx=0
        for i in range(0,min(pivot,len(s))):
            for j in range(min(i,len(s)-1),len(s)):
                if(pivot>s[j]):
                    s[i],s[j] = s[j],s[i]
                    pivotIdx +=1
        return qsort(s[:pivotIdx+1])+qsort(s[pivotIdx+1:])
    else:
        return s
def msort(data):
    dataLen  = len(data)
    dataLenDiv = int(dataLen//2)
    for i in range(0,dataLen+2):
        for j in range(0,dataLenDiv):
            if(data[j] > data[j+1]):
                data[j] , data[j+1] = data[j+1], data[j]
    
        for j in range(dataLenDiv,dataLen-1):
            if(data[j] > data[j+1]):
                data[j], data[j+1] = data[j+1] , data[j]
        checkData = data
        if(len(data)>1):
            data= msort(data[:dataLenDiv])+ msort(data[dataLenDiv:])
        notNeededContinue = True
        for j in range(0,len(data)):
           if(data[j] != checkData[j]):
               notNeededContinue=False
               break
        del checkData
        if(notNeededContinue):
            break
       
    return data
print(msort([32,990,23,1000,3000,6000,170,310,18,999999,2000,7,11,99,700,55])) #[1,5,2,4,3]))