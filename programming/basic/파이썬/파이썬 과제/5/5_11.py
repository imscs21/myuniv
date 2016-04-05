def mult(m,n): 
    ans=int(0);
    tempm=m;
    tempn=n;
    while(tempn>0):
        #print(tempm,tempn,ans)
        if tempn > 1: 
            if(tempn%2==0):
                tempm , tempn = tempm*2, tempn//2
                #tempm *= 2
                #tempn = tempn//2
            else:
                ans,tempm,tempn = ans+tempm,tempm*2,tempn//2
                #ans  += tempm;
                #tempm *= 2
                #tempn = tempn//2
                
                #return  loop(m*2,n//2,ans+m)
        else: # n == 1 
            break
    return tempm+ans
