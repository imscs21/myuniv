def insert0(x,ss): 
    if ss != []: 
        if x <= ss[0]: 
            return [x]+ss
        else: 
            return [ss[0]]+ insert0(x,ss[1:])
    else: 
        return [x]
