def merge0(left,right): 
    print(left,right)
    if not (left == [] or right == []): 
        if left[0] <= right[0]: 
            return [left[0]] + merge0(left[1:],right) 
        else: 
            return [right[0]] + merge0(left,right[1:]) 
    else: 
        return left + right

def msort(s): 
    if len(s) > 1: 
        mid = len(s) // 2 
        return merge0(msort(s[:mid]),msort(s[mid:])) 
    else: 
        return s

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
        
        for i in range(0,pivot):
            for j in range(min(i,len(s)-1),len(s)):
                if(pivot>s[j]):
                    
          
                    
                    s[i],s[j] = s[j],s[i]
                    pivotIdx +=1
                    
                        #break
        return qsort(s[:pivotIdx+1])+qsort(s[pivotIdx+1:])
    else:
        return s

def remerge(data):
    dataLen  = len(data)
    dataLenDiv = int(dataLen//2)
    
    
    for i in range(0,dataLenDiv):
        if(data[i] > data[dataLenDiv]):
                data[i] , data[i+1] = data[i+1], data[i]
    
    for i in range(dataLenDiv,dataLen-1):
        if(data[dataLenDiv] > data[i+1]):
                data[dataLenDiv], data[i+1] = data[i+1] , data[dataLenDiv]
    
        print("called")
    if(len(data)>1):
        data=remerge(data[:dataLenDiv])+remerge(data[dataLenDiv:])
        #data[:dataLenDiv] = remerge(data[:dataLenDiv+1])
    print(data)
    #data=remerge(data)
    
    for i in range(0,dataLenDiv):
        if(data[i] > data[dataLenDiv]):
            data[i] ,data[dataLenDiv]=data[dataLenDiv],data[i]
            
   
    return data
print(remerge([32,23,18,7,11,99,55])) #[1,5,2,4,3]))