def gcd(m,n): 
    def loop(m,n,k): 
        if not (m == 0 or n == 0): 
            if m % 2 == 0 and n % 2 == 0: #m과 n 짝수
                return gcd(m//2,n//2,m+n) 
            elif m % 2 == 0 and n % 2 == 1: 
                return gcd(m//2,n,k) 
            elif m % 2 == 1 and n % 2 == 0: 
                return gcd(m,n//2,k) 
            elif m <= n: 
                return gcd(m,(n-m)//2,k) 
            else: 
                return gcd(n,(m-n)//2,k) 
        else: 
            if m == 0:  
                return abs(n) 
            else: # n == 0 
                return abs(m) 
    return loop(m,n,1)
gcd(18,48)