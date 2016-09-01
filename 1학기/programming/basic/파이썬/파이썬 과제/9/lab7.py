"""
def minsteps0(n):
    if n > 1:
        r = 1 + minsteps0(n - 1)
        if n % 2 == 0:
            r = min(r, 1 + minsteps0(n // 2))
        if n % 3 == 0:
            r = min(r, 1 + minsteps0(n // 3))
        return r
    else:
        return 0

print(minsteps0(1))
print(minsteps0(2))
print(minsteps0(3))
print(minsteps0(4))
print(minsteps0(7))
print(minsteps0(10))
print(minsteps0(23))
print(minsteps0(237))
print(minsteps0(317))
print(minsteps0(514))

def minsteps1(n):
    memo = [0] * (n + 1)
    def loop(n,isMemo):
        print(memo)
        if n > 1:
            if memo[n] != 0:
                return memo[n]
            else:
                memo[n] = 1 + loop(n - 1,True)
                if n % 2 == 0:
                    memo[n] = min(memo[n], 1 + loop(n // 2,isMemo))
                if n % 3 == 0:
                    memo[n] = min(memo[n], 1 + loop(n // 3,isMemo))
                return memo[n]
        else:
            return 0
    return loop(n,False)

print(minsteps1(1))
print(minsteps1(2))
print(minsteps1(3))
print(minsteps1(4))
print(minsteps1(7))
print(minsteps1(10))
print(minsteps1(23))
#print(minsteps1(237))
#print(minsteps1(317))
#print(minsteps1(514))
#print(minsteps1(997))
#print(minsteps1(998))
"""
def minsteps(n):
    memo = [0] * (n + 1)
    for i in range(2,n+1):
        if(i%3 == 0):
            memo[i] = 1+min(memo[i//3],memo[i-1])
        elif(i%2 ==0):
            memo[i] =1+ min(memo[i//2], memo[i-1] )
        else:
            memo[i] = memo[i-1]+1
                
        
    #pass # for loop
    return memo[n]

print(minsteps(1),"original:", 0)
print(minsteps(2),"original:", 1)
print(minsteps(4),"original:", 2)

print(minsteps(7),"original:", 3)

print(minsteps(10),"original: ",3)
print(minsteps(11),"original:", 4)#prob 5

print(minsteps(17),"original:", 5)
print(minsteps(23)) # 6 #prob 7
print(minsteps(237)) # 8 #prob 10
print(minsteps(317)) # 10
print(minsteps(514)) # 8 #pron
print(minsteps(717)) # 11 #prob 14
print(minsteps(1993)) # 11 #prob 14
def gugudan1():
    startNum = int(2)
    for sn in range(2,10):
        s1=s2=""
        
        for n1 in range(2,6):
            s1 += str(sn).rjust(3)+"x".rjust(2)+str(n1).rjust(2)+"=".rjust(2)+str(n1*sn).rjust(3)
        for n2 in range(6,10):
            s2 += str(sn).rjust(3)+"x".rjust(2)+str(n2).rjust(2)+"=".rjust(2)+str(n2*sn).rjust(3)
        print(s1)
        print(s2)
        print(" ")
        
def gugudan2():
    s1=s2=""
    for sn in range(2,10):
        for n1 in range(2,6):
            s1 += str(n1).rjust(3)+ "x".rjust(2)+str(sn).rjust(2)+"=".rjust(2)+str(n1*sn).rjust(3)
        s1 += "\n"
        for n2 in range(6,10):
            s2 += str(n2).rjust(3)+ "x".rjust(2)+str(sn).rjust(2)+"=".rjust(2)+str(n2*sn).rjust(3)
        s2 += "\n"
        
    print(s1)
    print(" ")
    print(s2)
        
gugudan1()
gugudan2()

