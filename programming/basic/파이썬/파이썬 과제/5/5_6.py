def double(n):  
    return n * 2 
def halve(n):  
    return n // 2
def fastmult(m,n): 
    if n > 0: 
        if n % 2 == 0: 
            return fastmult(double(m),halve(n))
        else: 
            return  m+fastmult(m,n-1)
    else: 
        return 0
