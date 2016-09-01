def bin_search_ox(ss,key):
    while ss!= []:
        mid = len(ss)//2
        if(key == ss[mid]):
            return True
        elif key<ss[mid]:
            return ss = ss[:mid]
        else:
            return ss = ss[mid+1:]
    return False
    
def bin_search_ox2(ss,key):
    low = 0
    high = len(ss)-1
    while ss!= []:
        mid = len(ss)//2
        if(key == ss[mid]):
            return True
        elif key<ss[mid]:
            high = mid-1
        else:
            low = mid+1
    return False
    