def gcd(m,n): 
    m,n = min(abs(m),abs(n)),max(abs(m),abs(n))
    while(n>m):
        
        n = n%m
        
    return abs(n)
print(gcd(48,18))