def fastmult(m,n): 
    def loop(m,n,ans): 
        if n > 0: 
            if( n%2 ==0):
                return loop(m*2,n//2,ans)
            else:
                return m+loop(m,n-1,m+ans)
        else: 
            return 0;
    return loop(m,n,0)
