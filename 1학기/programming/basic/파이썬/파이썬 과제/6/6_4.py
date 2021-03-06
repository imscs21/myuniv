def merge0(left,right): 
    if not (left == [] or right == []): 
        if left[0] <= right[0]: 
            return [left[0]] + merge0(left[1:],right) 
        else: 
            return [right[0]] + merge0(left,right[1:]) 
    else: 
        return left + right
        
#실습 8
def merge1(left,right): 
    def loop(left,right,ss): 
        #print("sleft:  ",ss,"left: ",left,"right: ",right)
        if not (left == [] or right == []): 
            if left[0] <= right[0]: 
                ss.append(left[0]) 
                return loop(left[1:],right,ss)
            else: 
                ss.append(right[0]) 
                return loop(left,right[1:],ss)
        else: 
            return ss+left+right
    return loop(left,right,[])
    
#실습 9
def merge(left,right): 
    ss = [] 
    while not (left == [] or right == []): 
        if left[0] <= right[0]: 
            ss.append(left[0]) 
            left = left[1:]
        else: 
            ss.append(right[0]) 
            right = right[1:]
    return ss+left+right
    
def msort(s): 
  
    if len(s) > 1: 
        mid = len(s) // 2 
        return merge1(msort(s[:mid]),msort(s[mid:])) 
    else: 
        return s

print(msort([32,990,23,1000,3000,6000,170,310,18,999999,2000,7,11,99,700,55])) #[1,5,2,4,3]))
