def merge0(left,right): 
    print(left+right,left,right)
    if not (left == [] or right == []): 
        if left[0] <= right[0]: 
            return [left[0]] + merge0(left[1:],right) 
        else: 
            return [right[0]] + merge0(left,right[1:]) 
    else: 
        return left + right
        
def merge1(left,right): 
    def loop(left,right,ss): 
        print("sleft:  ",ss,"left: ",left,"right: ",right)
        if not (left == [] or right == []): 
            if left[0] <= right[0]: 
                #ss.append(left[0]) 
                #ss = ss+[left[0]]
                return loop(left[1:],right,ss)
            else: 
                #ss.append(right[0]) 
                #ss = ss+[right[0]]
                return loop(left,right[1:],ss)
        else: 
            return ss
    return loop(left,right,[])
    
def msort(s): 
    print("msort: ",s)
    if len(s) > 1: 
        mid = len(s) // 2 
        return merge0(msort(s[:mid]),msort(s[mid:])) 
    else: 
        return s
print(msort([32,23,18,7,11,99,55]))
