def fib(n):
    if(n>1):
        return fib(n-1)+ fib(n-2)
    else:
        return n
        
def fib_for(n): 
    bunny, rabby = 1, 0      
    for i in range(2, n + 1):
              bunny, rabby = rabby, bunny + rabby      
    return bunny + rabby
def fib2(n):
    i = 1
    bunny = 1
    rabby = 0
    while i<n:
        temp = bunny
        bunny = rabby
        rabby = temp+rabby
        i+=1
    return rabby+bunny
def comb(a,b):
    data = [[1 for _ in range(0,a-1)]]*(b-1)
    for i in range(1,len(data)):
        for j in range(1,len(data[i])):
            print(data)
            data[i+j-1][j] = data[i+j-1][j-1] + data[i-1+j-1][j] 
    print("final result: ",data)
comb(5,3)