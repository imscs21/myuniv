Grade_A = [90,100];
Grade_B = [80,89];
Grade_C = [70,79];
Grade_D = [60,69];
Grade_F = [0,59];

def getGrade(score):
    if(score>=Grade_A[0] and score <= Grade_A[1]):
        return "A";
    elif(score<Grade_A[0] and score >= Grade_B[0]):
       return "B"
    elif(score<Grade_B[0] and score >= Grade_C[0]):
       return "C";
    elif(score<Grade_C[0] and score >= Grade_D[0]):
       return "D";
     
    else:
       return "F";
    
def getQuestion(idx):
    if(idx==0):
        return "백분위 점수: ";
    elif(idx == 1 ):
        return "더할래?(y,n) "
    else: return "error";
class CoreFunctionContainer:
    def do(score):
        loopControl0 = True;
        while loopControl0:
            yourscore=0;
            try:
                tempValue1 = input(getQuestion(0));
                if(not tempValue1.isnumeric()):
                    continue;
                else:
                    yourscore = int(tempValue1);
                    if(yourscore>100 or yourscore<0):
                        continue;
                    else:
                        print("학점:",getGrade(yourscore));
                        break;
                   
            except:continue;
        del loopControl0;
            
def grade0():
    cfc = CoreFunctionContainer();
    cfc.do();
    print("1-가 프로그램 안녕");
    exit();
def grade1():
    cfc = CoreFunctionContainer();
    loopControl1 = True;
    while loopControl1:
        cfc.do();
        loopControl2 = True;
        while loopControl2:
        
            tempReply = input(getQuestion(1));
            tempReply = str(tempReply);
            if(tempReply == "n"):
                
                loopControl1 = False;
                loopControl2 = False;
               
            elif(tempReply =="y"):
                
                loopControl1 = True;
                loopControl2 = False;
            
            else:
                loopControl1 = True;
                loopControl2 = True;
                continue;
        del tempReply;
    
        del loopControl2;
    del loopControl1;

        
    print("1-나 프로그램 안녕");
    exit();
def bigger(a,b) : 
    if a > b : 
        return a ;
    else : 
        return b ;
def biggest(a,b,c): 
    return bigger(bigger(a,b),c) ;
def median(a,b,c):
    bgt = biggest(a,b,c);
    bgtV = 0;
    decArry = [a,b,c];
    decIdx = 0;
    idx1 = 0;
    idx2 = 0;
    if(bgt == a):
        decIdx = 0;
        idx1 = 1;
        idx2 = 2;
    elif (bgt == b):
    
        decIdx = 1;
        idx1 =0;
        idx2 =2;
    elif (bgt ==c):
        decIdx =2;
        idx1 = 0;
        idx2 = 1;    
    bgtV = decArry[decIdx];
   
    return bigger(decArry[idx1],decArry[idx2]);
    
import math;  
def format_ok(f,m,b) : 
   if(not f.isnumeric()):
       return False;
   if( not b.isnumeric()):
       return False;     
   if(not (m=="-")):
       return False;
   f1 = int(f);
   b1 = int(b);
   numberPosCount =  int(math.log10(f1));
   
   if(numberPosCount != 5):
       return False;
   numberPosCount = int(math.log10(b1));
   
   if(numberPosCount != 6):
       return False;
   return True;

def last_digit_ok(vals) : 
    return 11 - ((2*int(vals[0])+3*int(vals[1])+4*int(vals[2])+5*int(vals[3])+6*int(vals[4])+7*int(vals[5])+8*int(vals[6])+9*int(vals[7])+2*int(vals[8])+3*int(vals[9])+4*int(vals[10])+5*int(vals[11])) % 11);
   
def isRRN(message) : 
    s = input(message) ;
    (front,mid,back) = s.partition("-");
    while not (format_ok(front,mid,back) and last_digit_ok(front+back)) :          
        print("Invalid number") ;
        
        s = input(message);
        (front,mid,back) = s.partition("-");
    return s;
grade0();
