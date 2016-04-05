def sigma(n):
    def loop(n,sum):
        if(n>0):
            return loop(n-1,sum+1)
         else:
            return sum
    return loop(n,0)

def sigma(n):
    sum = 0
    while n>0:
        sum += n
        n -= 1
    return sum