#1번 문제
#====================
#1-가

def remove_one1(s,x):
    if(s != []):
        if(s[0]!=x ):
            return [s[0]]+remove_one1(s[1:],x)
        else:
            return  s[1:]
    else:
        return s   


def remove_one2(s,x):
    def loop(s,x,left):
        if(s!=[]):
            if(s[0]!=x):
                return loop(s[1:],x,left+[s[0]])
                
            else:
                return loop([],x,left+s[1:])
        else:
            return left
    return loop(s,x,[])



def remove_one3(s,x):
    left=[]
    
    if(s[0]==x):
        return s[1:]
    if(s != []):
        
        while(s[0] != x):
            
            left += [s[0]]
            s=s[1:]
           
            if(s==[]):
                break;
        if(s!=[]):
            left += s[1:]
            
    return left

   
#1-나
def remove_all1(s,x):
    if(s != []):
        if(s[0]!=x ):
            return [s[0]]+remove_all1(s[1:],x)
        else:
            return  remove_all1(s[1:],x)
    else:
        return s
    
  
      
def remove_all2(s,x):
    def loop(s,x,left):
        if(s!=[]):
            if(s[0]!=x):
                return loop(s[1:],x,left+[s[0]])
                
            else:
                return loop(s[1:],x,left)
        else:
            return left
    return loop(s,x,[])
    
    


def remove_all3(s,x):
    left=[]
    while(s != []): 
        while(s[0] != x):
            left += [s[0]]
            s=s[1:]
           
            if(s==[]):
                break;
        s=s[1:]
    return left
    
    
#1-다
def take1(s,n):
    
    if(s!=[] and n>= 0):
        v = s[n]
        if(s[0]!=v):
            
            return [s[0]]+take1(s[1:],n-1) 
        else:
            return []
        
    else:
        return s

def take2(s,n):
    def loop(s,n,left):
        if(s !=[] and n>=0):
            x = s[n]
            if(s[0] != x):
                return loop(s[1:],n-1,left+[s[0]])
            else:
                return loop([],n-1,left)
        else:
            return left
    return loop(s,n,[])
    

    
def take3(s,n):
    left = []
    if(s !=[] and n>=0):
        x = s[n]
        while (s[0] !=x and n>=0):
            left += [s[0]]
            s=s[1:]
            n=n-1
            if(n<0):
                break;
            x=s[n]
    return left
print(take3([1,5,2,8,3,0,6],1))
"""
def take1(s,x):
    
    if(s!=[]):
        if(s[0]!=x):
            return [s[0]]+take1(s[1:],x) 
        else:
            return []
        
    else:
        return s

def take2(s,x):
    def loop(s,x,left):
        if(s !=[]):
            if(s[0] != x):
                return loop(s[1:],x,left+[s[0]])
            else:
                return loop([],x,left)
        else:
            return left
    return loop(s,x,[])
    

    
def take3(s,x):
    left = []
    if(s !=[]):
        while (s[0] !=x):
            left += [s[0]]
            s=s[1:]
            if(s==[]):
                break;
    return left
"""


#2번 문제
#===================
#2-가
#(2-가)는 intersection 함수를 쓰는 것은 파이썬 함수 정의 순서상(name not found 혹은 no def func)으로 좋지 않고 
#1번 문제의 함수만은 사용가능하다 했기 떄문에 강제로 intersection3함수를 각 union,difference 내부에서 한번 더 정의함
def union1(xs,ys):
    if(not (xs==[] or ys == [])):
        inter =[] #intersection1(xs,ys)
        tempxs2 = xs
        tempys2 = ys
        while(tempxs2 != []):
            for val in tempys2:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
                if(tempxs2[0] ==val):
                    inter += [val]
                    tempys2 = remove_one3(tempys2,val)
                    break
            tempxs2 = tempxs2[1:]
        del tempxs2,tempys2
        
        if(inter !=[]):
            for val in inter:
                ys = remove_one1(ys,val)
        del inter
        if(ys == []):
            return [xs[0]]+union1(xs[1:],ys[1:])
        return [xs[0],ys[0]]+union1(xs[1:],ys[1:])
    else:
        return xs+ys 
  
def union2(xs,ys):
    def loop(xs,ys,result):
        if(not(xs==[] or ys == [])):
            inter =[] #intersection1(xs,ys)
            tempxs2 = xs
            tempys2 = ys
            while(tempxs2 != []):
                for val in tempys2:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
                    if(tempxs2[0] ==val):
                        inter += [val]
                        tempys2 = remove_one3(tempys2,val)
                        break
                tempxs2 = tempxs2[1:]
            del tempxs2,tempys2
            for val in inter:
                ys = remove_one2(ys,val)
            del inter
            if(ys==[]):
                return loop(xs[1:],ys,result+[xs[0]])
            return loop(xs[1:],ys[1:],result+[xs[0],ys[0]])    
        else:
            return result+xs+ys;
    return loop(xs,ys,[])
    
def union3(xs,ys):
    result=xs+ys
    inter = intersection3(xs,ys)
    while((inter != [])):
        result =remove_one3(result,inter[0])
        inter = inter[1:]
    del inter
    return result
    

#print("union3",union3([5,2,1,6],[1,9,8,7,2]))
#2-나
def intersection1(xs,ys):
    if(xs != []):
        for j in ys:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
            if(xs[0] == j ):
                return [j] + intersection1(xs[1:],ys)
                break
        return  []+intersection1(xs[1:],ys)
    else:
        return []

def intersection2(xs,ys):
    def loop(xs,ys,result):
        if(xs != []): 
            for j in ys: #리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
                if(xs[0]==j):
                    return loop(xs[1:],ys,result+[j])
                    break
            return loop(xs[1:],ys,[]+ result)#이경우 꼬리재귀 형식을 크게 벗어나지 않는다고 생각합니다
            
        else: return result
    return loop(xs,ys,[])
      
def intersection3(xs,ys):
    tempxs2 = xs
    tempys2 = ys
    result = []
    while(tempxs2 != []):
        for val in tempys2:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
            if(tempxs2[0] ==val):
                result += [val]
                tempys2 = remove_one3(tempys2,val)
                break
        tempxs2 = tempxs2[1:]
    del tempxs2,tempys2
    return result
    

#2-다 (xs 에서 ys빼기)
def difference1(xs,ys):
    if(ys != []):
        tempxs2 = xs
        tempys2 = ys
        result =[]
        while(tempxs2 != []):
            for val in tempys2:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
                if(tempxs2[0] ==val):
                    result += [val]
                    tempys2 = remove_one3(tempys2,val)
                    break
            tempxs2 = tempxs2[1:]
        ys = result
        del tempxs2,tempys2,result
        if(ys!=[]):
            xs = remove_one1(xs,ys[0])
            return []+difference1(xs,ys[1:])
        return []+difference1(xs,ys)
    else:   
        return xs
        
  
def difference2(xs,ys):
    def loop(xs,ys,result):
        if(ys != []):
            tempxs2 = xs
            tempys2 = ys
            inter = []
            while(tempxs2 != []):
                for val in tempys2:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
                    if(tempxs2[0] ==val):
                        inter += [val]
                        tempys2 = remove_one3(tempys2,val)
                        break
                tempxs2 = tempxs2[1:]
            ys = inter
            del tempxs2,tempys2,result
            if(ys!=[]):
                xs = remove_one2(xs,ys[0])
                return loop(xs,ys[1:],xs)
            return loop(xs,ys,xs)    
        else:
            
            return result
    return loop(xs,ys,[])
    

def difference3(xs,ys):
    tempxs2 = xs
    tempys2 = ys
    inter = []
    while(tempxs2 != []):
        for val in tempys2:#리스트의 순서가 일정하지 않을 경우를 대비해 비효율적이라도 체크하고 가는 로직
            if(tempxs2[0] ==val):
                inter += [val]
                tempys2 = remove_one3(tempys2,val)
                break
        tempxs2 = tempxs2[1:]
    del tempxs2,tempys2

    result=xs
    while(inter != []):
        result = remove_one3(result,inter[0])
        inter = inter[1:]
    return result


print("take")
print(take1([2,2,2,2],2))
print(take2([2,2,2,2],2))
print(take3([2,2,2,2],2))


print("difference")
print(difference1([1,2],[2,3]))
print(difference2([1,2],[2,3]))
print(difference3([1,2],[2,3]))
#print("difference3",difference3([5,2,1,6],[1,9,8,7,2]))   
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


#5번 문제
def seq_search_closest(s,key):
    if(s==[]):
        return None
    else:
        closeDepth = -1
        minCloseDept = max(abs(key-min(s)),abs(key-max(s)))
        minCloseValueIdx,closeValueIdx,indexx = 0,0,-1
        for i in range(0,len(s)):
            val = s[i]
            closeDepth = abs(key-val)
            indexx = indexx +1
            if((closeDepth < minCloseDept) or minCloseDept ==-1):
                minCloseDept,minCloseValueIdx = closeDepth,indexx
        return minCloseValueIdx
#6번 문제
#위키를 언급하면 이분검색은 오름차순으로 정렬된 배열'만' 가능
# https://ko.wikipedia.org/wiki/%EC%9D%B4%EC%A7%84_%EA%B2%80%EC%83%89_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
#원본 이분검색 알고리즘으로 랜덤배열검색해도 인덱스번호 잘못 찿음
#오름차순이 아닌 배열을 오름차순배열하면 배열값에대한 모든 인덱스 번호 달라짐
#해시테이블 저장은 효율이 안좋고 테이블에서 근사 인덱스값을 역으로 찿아가는것도 코드수를 3배이상 늘려가고 알고리즘도 비효울적
#따라서 6번문제에서 랜덤배열이나 내림차순배열같은 심한짓은 말아주세요;;;; :(
def bin_search_closest(ss,key):
    if(ss == []):
    
    
        return None 
    low  ,high,closeDepth,closeValueIdx = 0,(len(ss) - 1 ), -1,-1
    minCloseDept,minCloseValueIdx = max(abs(key-min(ss)),abs(key-max(ss))),0
    while low <= high: 
        mid = (high + low) // 2 
        if key == ss[mid]: 
            return mid 
        elif key < ss[mid]: 
            high = mid - 1 
        else: 
            low = mid + 1 
        closeDepth,closeValueIdx = abs(key-ss[mid]),mid
        if(closeDepth<minCloseDept):
            minCloseDept,minCloseValueIdx = closeDepth,closeValueIdx
    return minCloseValueIdx
"""
def bin_search_closest(ss,key): 
    low = 0 
    high = len(ss) - 1 
    closeDepth = -1
    closeValueIdx = -1
    minCloseDept = max(abs(key-min(ss)),abs(key-max(ss))) #max(ss)-min(ss)
    minCloseValueIdx = 0
    while low <= high: 
        mid = (high + low) // 2 
        if key == ss[mid]: 
            return mid 
        elif key < ss[mid]: 
            high = mid - 1 
        else: 
            low = mid + 1 
        closeDepth = abs(key-ss[mid])
        closeValueIdx = mid
        if(closeDepth<minCloseDept):
            minCloseDept = closeDepth
            minCloseValueIdx = closeValueIdx
    return minCloseValueIdx

"""
print(seq_search_closest([1,5,12,30,60,200],10))
