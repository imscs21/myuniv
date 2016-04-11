#1번 문제
#====================
#1-가

def remove_one1(s,x):
    if(s != []):
        if(s[0]!=x ):
            temp =[]
            temp.append( s[0])
            if(s != [] ):
                temp.extend( remove_one1(s[1:],x))
            return temp
        else:
            return  s[1:]
    else:
        return s   

def remove_one2(s,x):
    def loop(s,x,left):
        if(s!=[]):
            if(s[0]!=x and s != []):
                tleft = left
                tleft.append(s[0])
                return loop(s[1:],x,tleft)
            else:
                if(s!=[]):
                    left.extend(s[1:])
                return left
        else:
            return left
    return loop(s,x,[])

    

def remove_one3(s,x):
    left=[]
    
    if(s[0]==x):
        return s[1:]
    if(s != []):
        
        while(s[0] != x):
            left.append(s[0])
            s=s[1:]
            if(s==[]):
                break;
        if(s!=[]):
            left.extend(s[1:])
    return left
    
#1-나
def remove_all1(s,x):
    result = []
    result = s
    tresult = result
    tresult = remove_one1(tresult,x)
    if(len(tresult) == len(result)):
        del result
        return tresult
    else:
        return remove_all1(tresult,x)
    
    
  
    
def remove_all2(s,x):
    def loop(s,x,left,length,idx,result):
        if(idx < length):
           tresult = result;
           tresult = remove_one2(tresult,x)
           if(len(tresult) == len(result)):
               return result
           result = tresult
           del tresult
           return loop(s,x,left,length,idx+1,result)
        else:
            return result
    return loop(s,x,[],len(s),0,s)

def remove_all3(s,x):
    length = len(s)
    idx=int(0)
    result = []
    result = s
    while(idx<length):
        tresult = result
        tresult = remove_one2(tresult,x)
        if(len(tresult) == len(result) ):
            break;
        result = tresult
        del tresult;
        idx +=int(1)
        
    return result
#1-다
def take1(s,x):
    
    if(s!=[]):
        if(s[0]!=x):
            result = []
            result.append(s[0])
            result.extend(take1(s[1:],x))
            return result
        else:
            return []
        
    else:
        return s

def take2(s,x):
    def loop(s,x,left):
        if(s !=[]):
            if(s[0] != x):
                left.append(s[0])
                return loop(s[1:],x,left)
            else:
                return left
        else:
            return left
    return loop(s,x,[])
    
def take3(s,x):
    left = []
    if(s !=[]):
        while (s[0] !=x):
            left.append(s[0])
            s=s[1:]
            if(s==[]):
                break;
    return left

#2번 문제
#===================
#2-가
def union1(xs,ys):
    if(not (xs==[] or ys == [])):
        result = []
        result.extend([xs[0],ys[0]])
        result.extend(union1(xs[1:],ys[1:]))
        return result
    else:
        result =xs
        result.extend(ys)
        return result
    
def union2(xs,ys):
    def loop(xs,ys,result):
        if(not(xs==[] or ys == [])):
            result.append(xs[0])
            result.append(ys[0])
            return loop(xs[1:],ys[1:],result)
            
        else:
            result.extend(xs)
            result.extend(ys)
            return result;
    return loop(xs,ys,[])
    
def union3(xs,ys):
    tempxs = xs
    tempys = ys
    result=[]
    while(not(tempxs==[] or tempys == [])):
        result.append(tempxs[0])
        result.append(tempys[0])
        tempxs = tempxs[1:]
        tempys = tempys[1:]
    result.extend(tempxs)
    result.extend(tempys)
    return result

#2-나
def intersection1(xs,ys):
    return 0
def intersection2(xs,ys):
    return 0
def intersection3(xs,ys):
    tempxs = xs
    tempys = ys
    result = []
    lenx = len(xs)
    leny = len(ys)
    leng=0
    while(leng<lenx):
        
        for val in tempys:
            
            if(tempxs[leng] == val):
                
                result.append(val)
                tempys = remove_one3(tempys,val)
                break;
        leng += 1
    return result
#2-다
def difference1(xs,ys):
    return 0
def difference2(xs,ys):
    return 0
def difference3(xs,ys):
    return 0

print(intersection3([7,5,4,1,2,6,3],[1,3,8,2,9]))