# def fib(n): 
#     if n > 1:
#         return fib(n - 1) + fib(n - 2)
#     else:
#         return n

# def fib(n):
#     assert n > 0
#     i = 1
#     bunny, rabby = 1, 0
#     while i < n:
#         i += 1
#         bunny, rabby = rabby, bunny + rabby
#     return bunny + rabby

# def fib(n):
#     assert n > 0
#     bunny, rabby = 1, 0
#     for _ in range(2, n + 1):
#         bunny, rabby = rabby, bunny + rabby
#     return bunny + rabby

def fibseq(n):
    assert n > 0
    fibs= [0, 1]
    for i in range(2, n + 1):
        fibs.append(fibs[i - 1] + fibs[i - 2])
    return fibs

def fib(n):
    return fibseq(n).pop()

# print(fib(0)) # Assertion Error
# print(fib(1))
# print(fib(2))
# print(fib(3))
# print(fib(4))
# print(fib(5))
# print(fib(6))
# print(fib(7))
# print(fib(8))
# print(fib(9))
# print(fib(10))
# print(fib(11))
# print(fib(12))
# print(fibseq(12))


# def comb(n, r) :
#     if not (r == 0 or r == n) :
#         return comb(n - 1, r - 1) + comb(n - 1, r)
#     else :
#         return 1

def comb_pascal(n, r):
    matrix = [[]] * (n - r + 1)
    matrix[0] = [1] * (r + 1)
    for i in range(1, n - r + 1):
        matrix[i] = [1]
    for i in range(1, n - r + 1):
        for j in range(1,r + 1):
            newvalue = matrix[i][j - 1] + matrix[i - 1][j]
            matrix[i].append(newvalue)
    return matrix[n - r][r]
    
# def hanoitower(n, source, destination, temp) :
#     if n > 1 :
#         tower(n - 1, source, temp, destination)
#         print("move from", source, "to", destination)
#         tower(n - 1, temp, destination, source)
#     else :
#         print("move from", source, "to", destination)

# hanoitower(4, 1, 2, 3)


