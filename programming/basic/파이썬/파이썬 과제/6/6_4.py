def isort0(s): 
    if s != []: 
        return insert(s[0],isort0(s[1:])) 
    else: 
        return []
print(isort0([3,5,4,2]))