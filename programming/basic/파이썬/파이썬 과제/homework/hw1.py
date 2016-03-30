Grade_A = [int(90),int(100)] 
Grade_B = [int(80),int(89)] 
Grade_C = [int(70),int(79)] 
Grade_D = [int(60),int(69)] 
Grade_F = [int(0),int(59)] 

def GetGrade(score):
    if(score>=Grade_A[0] and score <= Grade_A[1]):
        return "A" 
    elif(score<Grade_A[0] and score >= Grade_B[0]):
       return "B" 
    elif(score<Grade_B[0] and score >= Grade_C[0]):
       return "C" 
    elif(score<Grade_C[0] and score >= Grade_D[0]):
       return "D" 
     
    else:
       return "F" 
    
def GetQuestion(idx):
    if (idx==0):
        return "백분위 점수: " 
    elif (idx == 1 ):
        return "더할래?(y/n)" 
    elif ( idx == 2 ):
        return "1-가 프로그램 안녕" 
    elif ( idx == 3):
        return "1-나 프로그램 안녕" 
    elif ( idx== 4 ):
        return "학점:" 
		
    else: return "error" 
class CoreFunctionContainer:
    def DoCoreFunction(score):
        loopControl0 = True 
        temoValue1 = "" 
        loopCount=int(0) 
        while (loopControl0):
            yourscore=0 
            loopCount=loopCount+1 
            if(loopCount > 200):
                loopControl0=False 
                break 
            try:   
               
                tempValue1 = input(GetQuestion(0)) 
                if(not tempValue1.isnumeric()):
                    continue 
                else:
                    yourscore = int(tempValue1) 
                    if(yourscore>100 or yourscore<0):
                        continue 
                    else:
                        print(GetQuestion(4),GetGrade(yourscore)) 
                        break 
            except:continue        

        del loopControl0 
            
def grade0():
    cfc = CoreFunctionContainer() 
    cfc.DoCoreFunction() 
    del cfc 
    print(GetQuestion(2)) 
    exit() 
def grade1():
    cfc = CoreFunctionContainer() 
    loopControl1 = True 
    while loopControl1:
        cfc.DoCoreFunction() 
        loopControl2 = True 
        tempReply="" 
        while loopControl2:
        
            tempReply = input(GetQuestion(1)) 
            
            tempReply = str(tempReply) 
            if(tempReply == "n"):
                
                loopControl1 = False 
                loopControl2 = False 
               
            elif(tempReply =="y" ):
                
                loopControl1 = True 
                loopControl2 = False 
            
            else:
                loopControl1 = True 
                loopControl2 = True 
                continue 
        del tempReply 
    
        del loopControl2 
    del loopControl1 

    del cfc    
    print(GetQuestion(3)) 
    exit() 
def bigger(a,b) : 
    if a > b : 
        return a  
    else : 
        return b  
def biggest(a,b,c): 
    return bigger(bigger(a,b),c)  
def median(a,b,c):
    if(  biggest(a,b,c) == a):
	    return bigger(b,c) 
    elif(  biggest(a,b,c) == b):
        return bigger(a,c) 
    elif(  biggest(a,b,c) == c):
        return bigger(b,a) 
		
    
import math   
def format_ok(f,m,b) : 

    if((not f.isnumeric()) or (not b.isnumeric()) or(not (m=="-"))):
        return False 	   
    f1 = int(f) 
    b1 = int(b) 
    numberPosCount =  int(math.log10(f1)) 
   
    if(numberPosCount != 5):
        return False 
    numberPosCount = int(math.log10(b1)) 
   
    if(numberPosCount != 6):
        return False 
    del numberPosCount    
    import datetime
    tyear =  int(f[:2])
    if (tyear > 20):
        tyear = int("19"+f[:2])
    else:
        tyear = int("20"+f[:2])
    try:
        tmonth =  int(f[2:4])
        tday = int(f[4:])
        tdate  = datetime.date(tyear, tmonth, tday);
        checkyear = tdate.year
        checkmonth = tdate.month
        checkday = tdate.day
        del checkday
        del checkmonth
        del checkyear
    except:
        return False
    return True 

def last_digit_ok(vals) : 
    return (11 - ((2*int(vals[0])+3*int(vals[1])+4*int(vals[2])+5*int(vals[3])+6*int(vals[4])+7*int(vals[5])+8*int(vals[6])+9*int(vals[7])+2*int(vals[8])+3*int(vals[9])+4*int(vals[10])+5*int(vals[11])) % 11))==int(vals[12]) 
   
def isRRN(message) : 
    s = input(message)  
    (front,mid,back) = s.partition("-") 
    while not (format_ok(front,mid,back) and last_digit_ok(front+back)) :          
        print("Invalid number")  
        
        s = input(message) 
        (front,mid,back) = s.partition("-") 
    return s 
#run function here

f = input("앞자리");
print(format_ok(f,"-","1234567"))
#tester.sh 파일에서 #/bin/sh가 아니라 #!/bin/sh라 생각됩니다 
#chmod 777 tester.sh
# ./tester.sh myhomework.py
