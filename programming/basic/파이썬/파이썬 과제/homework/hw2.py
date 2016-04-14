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
        inter = intersection1(xs,ys)
        for val in inter:
            ys = remove_one1(ys,val)
        del inter
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
            inter = intersection2(xs,ys)
            for val in inter:
                ys = remove_one2(ys,val)
            del inter
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
    inter = intersection3(xs,ys)
    for v in inter:
        result = remove_one3(result,v)
    del inter
    return result

#2-나
def intersection1(xs,ys):
    if(xs != []):
        for j in ys:
            if(xs[0] == j ):
                temp =[]
                temp.append( j)
                temp.extend( intersection1(xs[1:],ys))
                return temp
        return  intersection1(xs[1:],ys)#xs[1:]
    else:
        return []
    
def intersection2(xs,ys):
    def loop(xs,ys,result):
       
        if(xs != []):    
            for j in ys:
                if(xs[0]==j):
                    result.append(j)
            return loop(xs[1:],ys,result)
        else: return result
    return loop(xs,ys,[])
    
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
    
#2-다 (xs 에서 ys빼기)
def difference1(xs,ys):
    ys = intersection1(xs,ys)
    if(ys != []):
        xs = remove_one1(xs,ys[0])
        return difference1(xs,ys[1:])
    else:   
        return xs
def difference2(xs,ys):
    def loop(xs,ys,result):
        ys = intersection2(xs,ys)
        if(ys != []):
            xs = remove_one2(xs,ys[0])
            result = xs
            return loop(xs,ys[1:],result)    
        else:
            
            return result
    return loop(xs,ys,[])
    
def difference3(xs,ys):
    inter = intersection2(xs,ys)
    result=xs
    while(inter != []):
        result = remove_one3(result,inter[0])
        inter = inter[1:]
    return result
    
#문제 3
def greatest0(s): 
    def loop(s,top): 
        
        if s != []: 
            if s[0] > top: 
                return loop(s[1:],s[0]) 
            else: 
                return loop(s[1:],top) 
        else: 
            return top 
    if len(s) == 0: 
        return None 
    else: 
        return loop(s[1:],s[0])

#3번 while버전
def greatest1(s):
    result = int(-1)
    if(len(s) == 0):
        return None
    else:
        while(s != []):
            if s[0] > result: 
                result = s[0]
                s=s[1:]
                
            else: 
                s=s[1:]
        return result
#3번 for loop버전
def greatest(s):
    result = int(-1)
    if(len(s) == 0):
        return None
    else:
        for val in s:
            if(val > result):
                result = val
        return result
                
#i 번째 큰수 제거 (while 버전)
def rankith(s,i):
    if(s == []):
        return None
    elif(i==1):
        gst = greatest0(s);
        s.remove( gst)
        return gst
    else:
        gst = int(0)
        idx=1
        while(idx!=i):
            gst = greatest0(s)
            s.remove(gst)
            idx = idx+1
        gst = greatest0(s)
        return gst    
        
#4번 문제
def longest_repetition(s): 
    if s != []:
        record = s[0]      # 지금까지 가장큰 수
        recordtimes = 1    # 그 수의 연속반복 횟수   
        on = s[0]          # 현재 검사하고 있는 수         
        ontimes = 1        # 그 수의 연속반복 횟수         
        for n in s[1:]: 
        #impl start here
            if(n==on):
                ontimes = ontimes+1
            else:
                if(recordtimes < ontimes):
                    recordtimes = ontimes
                    record = on
                ontimes = 1
                on = n
        if(record==on):
            recordtimes = ontimes
        #impl end here
        return (record,recordtimes) 
    else: 
        return (None,0)

def genrandlist(m,n): 
    return [random.randrange(m) for _ in range(n)]


#5번 문제
def seq_search_closest(s,key):
    if(s==[]):
        return None
    else:
        
        closeDepth = -1
        minCloseDept = abs(key-max(s)) 
        closeValue=-1
        minCloseValue = -1
        minCloseValueIdx = 0
        closeValueIdx = 0
        indexx = -1
            #for val in s:
        for i in range(0,len(s)):
            val = s[i]
            closeDepth = abs(key-val)
            closeValue = val
            indexx = indexx +1
            if((closeDepth < minCloseDept) or minCloseDept ==-1):
                minCloseDept = closeDepth
                minCloseValue = closeValue
                minCloseValueIdx = indexx
        return minCloseValueIdx
#6번 문제
def bin_search_closest(s,key):
    if(s==[]):
        return None
    else:
        
        closeDepth = -1
        minCloseDept = abs(key-max(s)) 
        closeValue=-1
        minCloseValue = -1
        minCloseValueIdx = 0
        closeValueIdx = 0
        indexx = -1
            #for val in s:
        for i in range(0,len(s)):
            val = s[i]
            closeDepth = abs(key-val)
            closeValue = val
            indexx = indexx +1
            if((closeDepth < minCloseDept) or minCloseDept ==-1):
                minCloseDept = closeDepth
                minCloseValue = closeValue
                minCloseValueIdx = indexx
        return minCloseValueIdx
                    
def bin_search(ss,key): 
    low = 0 
    high = len(ss) - 1 
    closeDepth = -1
    minCloseDept = abs(key-max(ss)) 
    closeValue=-1
    minCloseValue = -1
    minCloseValueIdx = 0
    closeValueIdx = 0
    indexx = 0
    while low <= high: 
        mid = (high + low) // 2 
        val = ss[mid]
        closeDepth = abs(key-val)
        closeValue = val
        print(low,high,mid,"key: ",key)
        if((closeDepth < minCloseDept) or minCloseDept ==-1):
            minCloseDept = closeDepth
            minCloseValue = closeValue
            minCloseValueIdx = mid 
            return minCloseValueIdx 
        elif key < ss[mid]: 
            high = mid - 1 
        else: 
            low = mid + 1 
    return None

def test_bin_search(s,key): 
    print("Binary search test") 
    db = genrandlist(10000,1000) 
    db.sort() 
    db=s
    for i in range(10): 
        #key = random.randrange(len(s)) #random.randrange(10000) 
        index = bin_search(db,key) 
        print(key,"found at",index)

def linear_search_closest(s,key):
    return seq_search_closest(s,key)

def test_seq_search_closest(): 
    print("Sequential search test") 
    db = genrandlist(10000,1000) 
    for i in range(10): 
        key = random.randrange(10000) 
        index = seq_search_closest(db,key) 
        print("The closest value to",key,":",db[index],"at index",index) 
    key = random.randrange(10000) 
    index = seq_search_closest([],key) 
    print(key,"found at",index) # None
    
import random
test_bin_search([5,2,7,15],5)

#print(linear_search_closest([5,2,7,15],5) )