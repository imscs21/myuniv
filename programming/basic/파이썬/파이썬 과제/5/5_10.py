def mult(m,n): 
    def loop(m,n,ans): 
        if n > 1: 
            if(n%2==0):
                return loop(m*2,n//2,ans)
            else:
            
                return  loop(m*2,n//2,ans+m)
        else: # n == 1 
            return m+ans
    if n > 0: 
        return loop(m,n,0) 
    else: 
        return 0
