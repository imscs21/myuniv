def insert(x,ss): 
    left = []
    while ss != []: 
        if x <= ss[0]: 
            return  left+[x]+ss
        else: 
            ss, left =  ss[1:],left+[ss[0]]
            
    return left+[x]
def isort0(s): 
    if s != []: 
        return insert(s[0],isort0(s[1:])) 
    else: 
        return []

def isort1(s): 
    def loop(s,ss): 
        if s != []: 
            return loop(s[1:],
            insert(s[0],ss))
        else: 
            return ss
    return loop(s,[])
def isort(s) : 
    ss = [] 
    while s != []: 
        s, ss = s[1:], insert(s[0],ss)
        
    return ss
def isort_for(s) : 
    ss = [] 
    for i in s: 
        s, ss = s[1:], insert(s[0],ss)
        
    return ss
