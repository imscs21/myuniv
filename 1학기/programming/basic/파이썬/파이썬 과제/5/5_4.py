def mult(m,n): 
    def loop(n,ans): 
        if n > 0: 
            return m+ loop(n-1,ans+m)
        else: 
            return  0;
    return loop(n,0 )
