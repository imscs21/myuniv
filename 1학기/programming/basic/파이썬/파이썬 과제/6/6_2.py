
def insert1(x,ss): 
    def loop(ss,left): 
        if ss != []: 
            if x <= ss[0]: 
                return left+[x]+ss
            else: 
                return loop(ss[1:],left+[ss[0]])
        else: 
            return left+[x]
    return loop(ss,[])