def qsort(s): 
    print(s)
    if len(s) > 1: 
        pivot = s[0] 
        (left, right) = partition(pivot,s[1:]) 
        print("left: ",left," right: ",right," pivot: ",pivot)
        return qsort(left) + [pivot] + qsort(right) 
    else: 
        return s
def partition(pivot,s): 
    left, right = [], [] 
    for x in s: 
        if x <= pivot: 
            left.append(x) 
        else: 
            right.append(x) 
    return left, right

def bsort(s): 
    for k in range(0,len(s),1):
        for i in range(0,k):
            if s[i] > s[i+1]: 
                s[i], s[i+1] = s[i+1], s[i]
    return s

print("bsort")
print(bsort([32,23,18,7,11,99,55]))