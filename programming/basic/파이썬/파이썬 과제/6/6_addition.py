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
def remerge(data):
    dataLen  = len(data)
    dataLenDiv = int(dataLen//2)
    for i in range(0,dataLenDiv,dataLenDiv//2):
        for k in range(i-2,i+dataLenDiv//2):
            print(data[:dataLenDiv+1])
            if(data[k] >= data[k+1]):
                data[k] , data[k+1] = data[k+1], data[k]
    for i in range(dataLenDiv,dataLen-1,dataLenDiv//2):
        for k in range(dataLenDiv,dataLen-1, (dataLen-dataLenDiv)//2):
            if(data[k] >= data[k+1]):
                data[k], data[k+1] = data[k+1] , data[k]
    #for i in range(0,dataLen-1):
    #    if(data[i] >= data[i+1]):
    #        data[i],data[i+1] = data[i+1] , data[i]
    return data
print(remerge([32,23,18,7,11,99,55])) #[1,5,2,4,3]))