def isleapyear(year): 
    if(year<0):
        return 0;
    elif ((not ((year % 400)==0 )) and ((year%100)==0)):
        return False;
    elif ((year % 4)==0):
        return True;
    else: return False;
# test case 
for y in range(5): 
    print(y,isleapyear(y)) 
for y in range(2010,2017): 
    print(y,isleapyear(y)) 
for y in range(1900, 2600, 100): 
    print(y,isleapyear(y))